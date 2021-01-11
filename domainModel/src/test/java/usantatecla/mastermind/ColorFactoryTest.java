package usantatecla.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.utils.ColorCode;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ColorFactoryTest {

    ColorFactory colorFactory;

    @BeforeEach
    public void beforeEach() {
        this.colorFactory = ColorFactory.getInstance();
    }

    @Test
    public void testGivenColorFactoryWhenGetInitialsThenAllInitials() {
        assertThat(this.colorFactory.getInitials(), is("rbygcm"));
    }

    @Test
    public void testGivenColorFactoryWhenGetColorByCharacterThenColorCode() {
        assertThat(this.colorFactory.getColorByCharacter('r'), is(ColorCode.RED));
    }

    @Test
    public void testGivenColorFactoryWhenGetColorByCharacterThenColorCodeNull() {
        assertThat(this.colorFactory.getColorByCharacter('l'), is(ColorCode.NULL));
    }

    @Test
    public void testGivenColorFactoryWhenGetAllColorsThenReturn() {
        List<ColorCode> colorCodes = Arrays.asList(ColorCode.RED,
                ColorCode.BLUE,
                ColorCode.YELLOW,
                ColorCode.GREEN,
                ColorCode.CYAN,
                ColorCode.MAGENTA);
        assertThat(this.colorFactory.getAllColors(), is(colorCodes));
    }

}
