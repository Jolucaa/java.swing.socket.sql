package usantatecla.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ColorCodeTest {

    @Mock
    Console console;

    private ColorCode colorCode;

    @BeforeEach
    public void beforeEach() {
        this.colorCode = ColorCode.BLUE;
    }

    @Test
    public void testGivenColorCodeWhenCallGetColorThenReturnCorrectStringColor() {
        assertThat(this.colorCode.getColor(), is("\u001B[34m"));
    }

    @Test
    public void testGivenNullColorCodeWhenCallGetColorThenAssertError() {
        Assertions.assertThrows(AssertionError.class, () -> ColorCode.NULL.getColor());
    }

    @Test
    public void testGivenIndexWhenCallGetColorByIndexThenReturnCorrectStringColor() {
        assertThat(ColorCode.getColorByIndex(0), is("\u001B[30m"));
    }

    @Test
    public void testGivenOutOfBoundsIndexWhenCallGetColorByIndexThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> ColorCode.getColorByIndex(-1));
        Assertions.assertThrows(AssertionError.class, () -> ColorCode.getColorByIndex(ColorCode.NULL.ordinal()));
    }

    @Test
    public void testGivenColorCodeWhenGetInitialThenReturn() {
        assertThat(this.colorCode.getInitial(), is('b'));
    }

    @Test
    public void testGivenNotNullColorCodeWhenIsNullThenFalse() {
        assertThat(this.colorCode.isNull(), is(false));
    }

    @Test
    public void testGivenNullColorCodeWhenIsNullThenTrue() {
        assertThat(ColorCode.NULL.isNull(), is(true));
    }

    @Test
    public void testGivenColorCodeWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorCode.write();
            verify(this.console).write(this.colorCode.getColor() + this.colorCode.getInitial() + ColorCode.RESET_COLOR.getColor());
        }
    }

    @Test
    public void testGivenNullColorCodeWhenWriteThenZeroInteractions() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            ColorCode.NULL.write();
            verifyNoInteractions(this.console);
        }
    }
}
