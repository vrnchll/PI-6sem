import Exception.*;


public class Main {
    public static void main(String[] args) {
        try {
            AAA a1 = new AAA(22);
            a1.methode(0);
        }
        catch (ExceptionAAA1 e)
        {
            System.out.println("Parameter is null");
        }
        catch (ExceptionAAA2 e)
        {
            System.out.println("Parameter is 0");
        }
        catch (ExceptionAAA3 e)
        {
            System.out.println("Parameter < 0");
        }
        finally {
        }
    }
}
