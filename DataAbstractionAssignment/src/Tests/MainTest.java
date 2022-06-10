import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import static junit.framework.TestCase.assertEquals;

public class MainTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();
    @Test
    public void testDepositChecking(){
        double balance =  Main.depositChecking(100);
        double expected = 110.0;
        try{
            assertEquals("Deposit: " + 100, expected, balance);
        }catch(Throwable e){
            collector.addError(e);
        }
    }

    @Test
    public void testDepositSaving(){
        double balance =  Main.depositSaving(100);
        double expected = 120.0;
        try{
            assertEquals("Deposit: " + 100, expected, balance);
        }catch(Throwable e){
            collector.addError(e);
        }
    }

    @Test
    public void testWithdrawChecking() {
        double balance =  Main.withdrawChecking(100);
        double expected = -90.0;
        try{
            assertEquals("Withdraw: " + 100, expected, balance);
        }catch(Throwable e){
            collector.addError(e);
        }
    }

    @Test
    public void testCheckingOverdraft() {
        double balance =  Main.withdrawChecking(200);
        double expected = 10.0;
        try{
            assertEquals("Withdraw: " + 200, expected, balance);
        }catch(Throwable e){
            collector.addError(e);
        }
    }

    @Test
    public void testWithdrawSaving() {
        double balance =  Main.withdrawSaving(100);
        double expected = -80.0;
        try{
            assertEquals("Withdraw: " + 100, expected, balance);
        }catch(Throwable e){
            collector.addError(e);
        }
    }

    @Test
    public void testSavingOverdraft() {
        double balance =  Main.withdrawSaving(200);
        double expected = 20.0;
        try{
            assertEquals("Withdraw: " + 200, expected, balance);
        }catch(Throwable e){
            collector.addError(e);
        }
    }

}