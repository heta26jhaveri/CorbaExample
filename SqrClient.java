
import Sqr.Sqr_interface;
import Sqr.Sqr_interfaceHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author apple
 */
public class SqrClient {

    public static void main(String[] args) {
        try {

            // 1. Get an ORB object by calling init() method.
            ORB orb = ORB.init(args, null);

            // 2. Get the reference object of “NameService”.
            org.omg.CORBA.Object nameserviceref = orb.resolve_initial_references("NameService");

            // 3. Bind the object with NamingContextExt by calling narrow() method.
            NamingContextExt name = NamingContextExtHelper.narrow(nameserviceref);

            // 4. Resolve the stringified name by calling resolve_str() on the name context object.
            org.omg.CORBA.Object nameref = name.resolve_str("SQRName.sqr");

            // 5. Narrow the object by calling narrow() on interfaceHepler class.
            Sqr_interface sqr = Sqr_interfaceHelper.narrow(nameref);

            // 6. Call the method on interface object.
            int x = sqr.findSqr(7);
            System.out.println("Sqr = " + x);
            System.out.println("Client exiting");

        } catch (Exception e) {
            System.out.println("Oops Exception on the Client Side: " + e.toString());
        }
    }

}
