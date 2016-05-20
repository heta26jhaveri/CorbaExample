
import Sqr.Sqr_interface;
import Sqr.Sqr_interfaceHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author apple
 */
public class SqrServer {

    public static void main(String[] args) {
        try {
            // 1. Get an ORB object by calling init() method.
            ORB orb = ORB.init(args, null);

            // 2. Bind the orb object with the implementation file.
            Sqr_impl simpl = new Sqr_impl(orb);

            // 3. Get the reference object of “RootPOA”.
            org.omg.CORBA.Object rootobj = orb.resolve_initial_references("RootPOA");

            // 4. Bind the object with the POA by calling narrow() method and activate it.
            POA poa = POAHelper.narrow(rootobj);
            poa.the_POAManager().activate();

            // 5. Get the reference object of “NameService”.
            org.omg.CORBA.Object nameobj = orb.resolve_initial_references("NameService");

            // 6. Bind the object with NamingContextExt by calling narrow() method.
            NamingContextExt name = NamingContextExtHelper.narrow(nameobj);

            // 7. Get the reference object of implementation object by calling servant_to_reference on poa.
            org.omg.CORBA.Object sqrobj = poa.servant_to_reference(simpl);

            // 8. Bind the object with the interface by calling narrow() method.
            Sqr_interface sqr = Sqr_interfaceHelper.narrow(sqrobj);

            // 9. Set the stringified name to be bound with the object using to_name() method on namingcontextobj;
            NameComponent[] nc = name.to_name("SQRName.sqr");

            // 10. Bind the stringified object with the interface object by calling rebind() method.
            name.rebind(nc, sqr);
            System.out.println("Server is waiting");

            // 11. call the orb.run() method.
            orb.run();

        } catch (Exception e) {
            System.out.println("Oops Exception on the Server Side: " + e.toString());
        }
        System.out.println("Server Exiting ...");
    }

}
