
import edu.hm.kdiery.mvc.view.Callout;

public class SimpleTests {

	public static void main(String... args) {
		System.out.printf(Callout.Going1st.getFormatBid() + "\n", 30);
		System.out.printf(Callout.Going2nd.getFormatBid() + "\n", 30);
		System.out.printf(Callout.Remaining3.getFormatBid() + "\n", 30);
		System.out.printf(Callout.Remaining4.getFormatBid() + "\n", 30);
		System.out.printf(Callout.Done.getFormatBid() + "\n", 30);
		
		System.out.printf(Callout.Going1st.getFormatNobid() + "\n", 30);
		System.out.printf(Callout.Going2nd.getFormatNobid() + "\n", 30);
		System.out.printf(Callout.Remaining3.getFormatNobid() + "\n", 30);
		System.out.printf(Callout.Remaining4.getFormatNobid() + "\n", 30);
		System.out.printf(Callout.Done.getFormatNobid() + "\n", 30);

	}

}
