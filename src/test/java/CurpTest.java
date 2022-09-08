import com.aram.curp.model.MexicanCurpCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CurpTest {

    @Test
    public void can_recognize_valid_mexican_curp_codes() {
        // Valid mexican curp codes
        final var curp1 = "FABM770222MMSJNR00";
        final var curp2 = "CAAL490723MOCBLB07";
        final var curp3 = "MAVI810101MGRCLN08";
        final var curp4 = "QUSC480503MMSVNR01";
        final var curp5 = "TAAV670327MMSFNC02";

        assertTrue(MexicanCurpCode.isValid(curp1));
        assertTrue(MexicanCurpCode.isValid(curp2));
        assertTrue(MexicanCurpCode.isValid(curp3));
        assertTrue(MexicanCurpCode.isValid(curp4));
        assertTrue(MexicanCurpCode.isValid(curp5));

    }

    @Test
    public void can_recognize_invalid_mexican_curp_codes() {
        // Invalid mexican curp codes
        final var invalid1 = "7777770222MMSJNR00";
        final var invalid2 = "5555490723MOCBLB07";
        final var invalid3 = "MAVI81010176675408";
        final var invalid4 = "M$!2480503MMSVNR01";
        final var invalid5 = "7/&5670327MMSFNC02";

        assertFalse(MexicanCurpCode.isValid(invalid1));
        assertFalse(MexicanCurpCode.isValid(invalid2));
        assertFalse(MexicanCurpCode.isValid(invalid3));
        assertFalse(MexicanCurpCode.isValid(invalid4));
        assertFalse(MexicanCurpCode.isValid(invalid5));

    }

    @Test
    public void throws_NPE_when_providing_null_input() {
        assertThrows(NullPointerException.class,
                () -> MexicanCurpCode.isValid(null));
    }



}
