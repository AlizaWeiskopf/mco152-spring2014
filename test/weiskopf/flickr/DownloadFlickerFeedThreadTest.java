package weiskopf.flickr;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class DownloadFlickerFeedThreadTest {

	@Test
	public void testCallsLoadImages() {// don't want to test the frame, only if
										// it's CALLING the method, not even
										// what the method is doing
		// also testing if url connection code is in the run method and not the
		// constructor
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);// this is
																		// what
																		// we
																		// want
																		// to
																		// mock
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);

		VerificationMode never = Mockito.never();
		Mockito.verify(frame, never).loadImages(Mockito.any(FlickerFeed.class));// at
																				// this
																				// point
																				// loadImages
																				// should
																				// not
																				// have
																				// been
																				// called,
																				// confirms
																				// that
																				// this
																				// code
																				// is
																				// not
																				// in
																				// the
																				// constructor

		thread.run();

		VerificationMode once = Mockito.times(1);
		Mockito.verify(frame, once).loadImages(Mockito.any(FlickerFeed.class));// verify
																				// that
																				// this
																				// method
																				// was
																				// called
																				// once
																				// -
																				// put
																				// load
																				// images
																				// outside
																				// the
																				// verify
																				// method!
	}

}
