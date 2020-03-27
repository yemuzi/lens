import com.niulib.aisdk.Const;
import com.niulib.aisdk.Lens;

/*
 * NOTE:
 * add external jar first:
 * niulib-aisdk.jar 
 * 
 */
public class Test {

	public static void main(String[] args) {
		// 1.init
		 Lens engine = new Lens();
		
		// 2.active
		int retAct=engine.active("");
		if (Const.MACT_SUCCESS == retAct) {
			System.out.println(Const.getString(Const.MACT_SUCCESS));
		} else if (Const.MACT_TIME_PASSED == retAct) {
			System.out.println(Const
					.getString(Const.MACT_TIME_PASSED));
		} else {
			System.out.println(Const
					.getString(Const.MACT_FAILED));
		}

		String outFilename = "out.jpg"; // 叠加后的效果图， 空值表示不输出

		// 3.process

		long startTime = System.currentTimeMillis();
		
		int ret = engine.deDistortionH("distortion1.jpg", outFilename,0.15f);  // 0-1
//		int ret = engine.deDistortionV("distortion2.jpg", outFilename);
//		int ret = engine.textCorrection("text.jpg", outFilename); 
		
		long endTime = System.currentTimeMillis();
		long usedTime = (endTime - startTime);

		if (Const.MERR_READ_IMAGE_FAILED == ret) {
			System.out.println(Const.getString(Const.MERR_READ_IMAGE_FAILED));
		} else if (Const.MERR_NORMAL == ret) {
			System.out.println(Const.getString(Const.MERR_NORMAL));
		}	else if (Const.MERR_ONLY_SINGLE_THREAD == ret) {
			System.out.println(Const.getString(Const.MERR_ONLY_SINGLE_THREAD));
		}	else {
			System.out.println(Const.getString(Const.MERR_OTHER));
		}
		
		System.out.println("finish...,time:" + usedTime + " ms");
	}

}
