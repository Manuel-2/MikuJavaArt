package art;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.geom.*;

public class Miku extends JPanel {
	private Color cian = new Color(85, 230, 230);
	private Color white = new Color(255, 255, 255);
	private Color magenta = new Color(240, 15, 105);
	private Color black = new Color(10, 10, 10);

	public Miku() {
		setVisible(true);
		setBackground(cian);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

//		new Rectangle2D.Double(0, 0, 0, 0);
//		new Ellipse2D.Double(0, 0, 0, 0);

		// Left Headphone ===================
		g2.setPaint(black);
		Area leftHeadponeBase = new Area(new Ellipse2D.Double(150, 230, 137, 125));
		g2.fill(leftHeadponeBase);

		Area mic = new Area(new Ellipse2D.Double(221, 424, 24, 13));
		g2.fill(mic);

		Area micBody1 = new Area(new Ellipse2D.Double(191, 287, 180, 165));
		Area micBody1Sub = new Area(new Ellipse2D.Double(206, 302, 180, 160));
		micBody1.subtract(micBody1Sub);
		g2.fill(micBody1);

		// Shoulders and Body ========================
		g2.setPaint(white);
		Area leftShoulder = new Area(new Ellipse2D.Double(91, 530, 209, 191));
		Area rightShoulder = new Area(new Ellipse2D.Double(410, 533, 200, 115));
		g2.fill(leftShoulder);
		g2.fill(rightShoulder);

		g2.setPaint(black);
		Area shirtBase = new Area(new Ellipse2D.Double(57, 448, 657, 348));
		Area shirtBaseRightsub1 = new Area(new Rectangle2D.Double(482, 452, 37, 37));
		Area shirtBaseRightsub2 = new Area(new Ellipse2D.Double(481, 398, 364, 161));
//		Area shirtBaseRightsub3 = new Area(new Ellipse2D.Double(563, 500, 200, 200));
		Area shirtBaseRightsub3 = new Area(new Ellipse2D.Double(515, 460, 300, 300));
		shirtBase.subtract(shirtBaseRightsub1);
		shirtBase.subtract(shirtBaseRightsub2);
		shirtBase.subtract(shirtBaseRightsub3);
		// left substractions
		Area shirtBaseLeftsub1 = new Area(new Ellipse2D.Double(91, 331, 184, 200));
		Area shirtBaseLeftsub2 = new Area(new Rectangle2D.Double(-1, 500, 204, 204));
		shirtBase.subtract(shirtBaseLeftsub1);
		shirtBase.subtract(shirtBaseLeftsub2);

		Area shirtBaseLeftAdd1 = new Area(new Ellipse2D.Double(164, 528, 89, 338));
		shirtBase.add(shirtBaseLeftAdd1);
		g2.fill(shirtBase);

		g2.setPaint(black);
		int neckShadowPointsX[] = { 309, 357, 311 };
		int neckShadowPointsY[] = { 455, 411, 430 };
		Area neckShadow = generatePoligon(neckShadowPointsX, neckShadowPointsY);
		g2.fill(neckShadow);

		// tie
		g2.setPaint(cian);
		int tieX[] = { 354, 345, 280, 292 };
		int tieY[] = { 545, 600, 600, 527 };
		Area mainTie = generatePoligon(tieX, tieY);
		g2.fill(mainTie);
		Area tieTop = new Area(new Ellipse2D.Double(253, 524, 102, 42));

		Area tieTopSub1 = new Area(new Rectangle(253, 520, 40, 50));
		tieTop.subtract(tieTopSub1);
		g2.fill(tieTop);
		// Face ======================================

		g2.setPaint(white);
		int faceXPoints[] = { 185, 460, 460, 442, 338, 305, 309, 357, 302, 185 };
		int faceYPoints[] = { 160, 160, 470, 470, 496, 473, 455, 411, 437, 354 };

		GeneralPath face = new GeneralPath(GeneralPath.WIND_EVEN_ODD, faceXPoints.length);
		face.moveTo(faceXPoints[0], faceYPoints[0]);
		for (int index = 1; index < faceXPoints.length; index++) {
			face.lineTo(faceXPoints[index], faceYPoints[index]);

		}
		face.closePath();
		Area test1 = new Area(face);
		Area neckRightSub = new Area(new Ellipse2D.Double(426, 271, 300, 300));
		test1.subtract(neckRightSub);
		g2.fill(test1);

		g2.setPaint(white);
		Area leftFaceBase = new Area(new Ellipse2D.Double(149, 149, 119, 284));
		Area leftFaceBaseSub = new Area(new Ellipse2D.Double(31, 260, 158, 319));
		Area LeftFaceBaseCut = new Area(new Rectangle2D.Double(180, 365, 75, 70));
		leftFaceBase.subtract(leftFaceBaseSub);
		leftFaceBase.subtract(LeftFaceBaseCut);
		g2.fill(leftFaceBase);

		Area leftChinBase = new Area(new Ellipse2D.Double(160, 150, 432, 295));
		Area leftChinBaseSub = new Area(new Rectangle2D.Double(15, 110, 170, 420));
		Area leftChinBaseSub2 = new Area(new Rectangle2D.Double(304, 110, 300, 420));
		leftChinBase.subtract(leftChinBaseSub);
		leftChinBase.subtract(leftChinBaseSub2);
		g2.fill(leftChinBase);

		// mount
		g2.setPaint(cian);
		CubicCurve2D.Double mountBase = new CubicCurve2D.Double();
		Point2D.Double mbStart, mbEnd, mbControl, mbControl2;
		mbStart = new Point2D.Double(305, 380);
		mbControl = new Point2D.Double(320, 416);
		mbControl2 = new Point2D.Double(290, 420);
		mbEnd = new Point2D.Double(277, 386);
		mountBase.setCurve(mbStart, mbControl, mbControl2, mbEnd);
		Area mountBaseArea = new Area(mountBase);
		Area mountLeftSub = new Area(new Ellipse2D.Double(194, 378, 107, 103));
		mountBaseArea.subtract(mountLeftSub);
		g2.fill(mountBaseArea);

		// nose shadow
		int noseX[] = { 256, 262, 260 };
		int noseY[] = { 356, 358, 362 };
		Area noseShadowPolygon = generatePoligon(noseX, noseY);
		g2.fill(noseShadowPolygon);

		// Eyes ======================================

		// left eye
		g2.setPaint(cian);
		Area leftEyeBottomPart = new Area(new Ellipse2D.Double(136, 264, 100, 110));
		Area leftEyeTopPart = new Area(new Ellipse2D.Double(182, 201, 79, 136));
		leftEyeBottomPart.intersect(leftEyeTopPart);
		g2.fill(leftEyeBottomPart);

		g2.setPaint(black);
		Area leftInnerEyeBottomPart = new Area(new Ellipse2D.Double(168, 268, 65, 107));
		Area leftInnerEyeTopPart = new Area(new Ellipse2D.Double(203, 222, 65, 107));
		leftInnerEyeBottomPart.intersect(leftInnerEyeTopPart);
		Area leftInnerEyeSmallRemoveBottom = new Area(new Ellipse2D.Double(226, 314, 22, 25));
		leftInnerEyeBottomPart.subtract(leftInnerEyeSmallRemoveBottom);
		g2.fill(leftInnerEyeBottomPart);

		g2.fill(new Ellipse2D.Double(221, 306, 12, 20));
		g2.setPaint(white);
		g2.fill(new Ellipse2D.Double(198, 282, 10, 10));

		// left eyebrow
		g2.setPaint(black);
		Area leftEyebrowBase = new Area(new Ellipse2D.Double(93, 254, 144, 98));
		Area leftEyebrowsub1 = new Area(new Ellipse2D.Double(93, 270, 152, 106));
		Area leftEyebrowsub2 = new Area(new Rectangle2D.Double(93, 243, 76, 140));
		leftEyebrowBase.subtract(leftEyebrowsub1);
		leftEyebrowBase.subtract(leftEyebrowsub2);
		Area leftEyebrowAdd1 = new Area(new Ellipse2D.Double(155, 255, 23, 16));
		leftEyebrowBase.add(leftEyebrowAdd1);
		g2.fill(leftEyebrowBase);

		int rREAXPoints[] = { 158, 176, 169, 153 };
		int rREAYPoints[] = { 257, 273, 285, 263 };
		Area rotatedRectangleEyebrowAdd = generatePoligon(rREAXPoints, rREAYPoints);
		Area rREAD1 = new Area(new Ellipse2D.Double(167, 268, 40, 20));
		rotatedRectangleEyebrowAdd.subtract(rREAD1);
		g2.fill(rotatedRectangleEyebrowAdd);

		// left bottom eyebrow
		g2.setPaint(black);
		QuadCurve2D.Double bottomEyebrown = new QuadCurve2D.Double();
		Point2D.Double start, end, control;
		start = new Point2D.Double(198, 336);
		control = new Point2D.Double(208, 342);
		end = new Point2D.Double(232, 338);
		bottomEyebrown.setCurve(start, control, end);
		g2.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2.draw(bottomEyebrown);

		// right eye
		g2.setPaint(cian);
		CubicCurve2D.Double rigthEyeBase = new CubicCurve2D.Double();
		Point2D.Double rebStart, rebEnd, rebControl, rebControl2;
		rebStart = new Point2D.Double(350, 232 + 10);
		rebControl = new Point2D.Double(318, 338 + 5);
		rebControl2 = new Point2D.Double(410, 350 + 5);
		rebEnd = new Point2D.Double(411, 232 + 10);
		rigthEyeBase.setCurve(rebStart, rebControl, rebControl2, rebEnd);
		g2.fill(rigthEyeBase);

		// right inner eye
		g2.setPaint(black);
		Area rightInnerEye = new Area(new Ellipse2D.Double(364, 223 + 10, 40, 70));
		g2.fill(rightInnerEye);
		g2.setPaint(white);
		Area rightInnerEyeWhite = new Area(new Ellipse2D.Double(360, 254, 10, 10));
		g2.fill(rightInnerEyeWhite);

		// right bottom eyebrow
		g2.setPaint(black);
		QuadCurve2D.Double rightbottomEyebrown = new QuadCurve2D.Double();
		Point2D.Double rbebstart, rbebend, ebebcontrol;
		rbebstart = new Point2D.Double(351, 324);
		ebebcontrol = new Point2D.Double(370, 327);
		rbebend = new Point2D.Double(394, 312);
		rightbottomEyebrown.setCurve(rbebstart, ebebcontrol, rbebend);
		g2.setStroke(new BasicStroke(5.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2.draw(rightbottomEyebrown);

		// Main Hair =================================

		g2.setPaint(cian);
		Area MainHairCenterBase1 = new Area(new Ellipse2D.Double(187, -107, 365, 432));
		Area MainHairCenterBase1Sub = new Area(new Ellipse2D.Double(282, -67, 280, 473));
		MainHairCenterBase1.subtract(MainHairCenterBase1Sub);
		g2.fill(MainHairCenterBase1);

		Area RightHairCenterBase1 = new Area(new Ellipse2D.Double(230, -175, 793, 447));
		g2.fill(RightHairCenterBase1);

		Area FaarRightHairCenterBase1 = new Area(new Ellipse2D.Double(161, 0, 314, 469));
		Area FaarRightHairCenterBase1Sub = new Area(new Ellipse2D.Double(62, 0, 352, 542));
		FaarRightHairCenterBase1.subtract(FaarRightHairCenterBase1Sub);
		g2.fill(FaarRightHairCenterBase1);

		// Hair Accessories ==========================

		g2.setPaint(black);
		int leftAccesoryX[] = { 126, 156, 93 + 30, 93 };
		int leftAccesoryY[] = { 0, 0, 71, 71 };
		Area LeftAccesory = generatePoligon(leftAccesoryX, leftAccesoryY);
		Area LeftAccesorySub1 = new Area(new Ellipse2D.Double(63, 9, 348, 291));
		LeftAccesory.subtract(LeftAccesorySub1);
		g2.fill(LeftAccesory);

		g2.setPaint(magenta);
		int leftAccesoryInnerX[] = { 138, 145, 111, 103 };
		int leftAccesoryInnerY[] = { 0, 0, 71, 71 };
		Area LeftAccesoryInner = generatePoligon(leftAccesoryInnerX, leftAccesoryInnerY);
		LeftAccesoryInner.subtract(LeftAccesorySub1);
		g2.fill(LeftAccesoryInner);

		g2.setPaint(black);
		int rigthAccesoryX[] = { 503, 478, 546, 552, 442, 464 };
		int rigthAccesoryY[] = { 0, 36, 97, 128, 32, 0 };
		Area rightAccesory = generatePoligon(rigthAccesoryX, rigthAccesoryY);
		g2.fill(rightAccesory);

		g2.setPaint(magenta);
		int rightAccesoryInnerX[] = { 488, 462, 548, 550, 452, 476 };
		int rigthAccesoryInnerY[] = { 0, 34, 109, 118, 32, 0 };
		Area rightAccesoryInner = generatePoligon(rightAccesoryInnerX, rigthAccesoryInnerY);
		g2.fill(rightAccesoryInner);

		// RIGHT headphen
		g2.setPaint(black);
		CubicCurve2D.Double headphone = new CubicCurve2D.Double();
		Point2D.Double hStart, hControl1, hEnd, hControl2;
		hStart = new Point2D.Double(477, 169);
		hControl1 = new Point2D.Double(576, 130);
		hControl2 = new Point2D.Double(526, 400);
		hEnd = new Point2D.Double(512, 315);
		headphone.setCurve(hStart, hControl1, hControl2, hEnd);
		Area headphoneArea = new Area(headphone);
		Area headponesub1 = new Area(new Ellipse2D.Double(466, 316, 159, 76));
		headphoneArea.subtract(headponesub1);
		g2.fill(headphoneArea);

		g2.setPaint(magenta);
		Area headphonemagenta = new Area(new Ellipse2D.Double(461, 189, 53, 158));
		headphonemagenta.intersect(new Area(headphone));
		g2.fill(headphonemagenta);

		g2.setPaint(black);
		int smallRightTriangleX[] = { 488, 494, 477 };
		int smallRightTriangleY[] = { 312, 327, 333 };
		Area smallRightTriangle = generatePoligon(smallRightTriangleX, smallRightTriangleY);
		smallRightTriangle.subtract(headponesub1);
		g2.fill(smallRightTriangle);

		// EYES =======================================

		// right top eyebrow
		g2.setPaint(black);
		CubicCurve2D.Double rightTopEyebrow = new CubicCurve2D.Double();
		Point2D.Double rteStart, rteEnd, rteControl, rteControl2;
		rteStart = new Point2D.Double(310, 276);
		rteControl = new Point2D.Double(315, 210);
		rteControl2 = new Point2D.Double(470, 220);
		rteEnd = new Point2D.Double(426, 263);
		rightTopEyebrow.setCurve(rteStart, rteControl, rteControl2, rteEnd);
		Area rightTopEyebrowArea = new Area(rightTopEyebrow);
		Area rightTopEyebrowAreaSub1 = new Area(new Ellipse2D.Double(297, 247, 161, 140));
		Area rightTopEyebrowAreaSub2 = new Area(new Ellipse2D.Double(383, 247, 45, 25));
		rightTopEyebrowArea.subtract(rightTopEyebrowAreaSub1);
		rightTopEyebrowArea.subtract(rightTopEyebrowAreaSub2);
		g2.fill(rightTopEyebrowArea);

		// rit top eyebrow right corner
		// ya no se que nombre ponerle a las variables
		int dinosaurioX[] = { 415, 442, 428 };
		int dinosaurioY[] = { 232, 240, 261 };
		Area dinosaurioPoligon = generatePoligon(dinosaurioX, dinosaurioY);
		g2.fill(dinosaurioPoligon);

		// asdlk;fjasd;fjklasdfjads
		// para este punto deberia escribir funciones pero ya esta implementado
		g2.setPaint(cian);
		g2.setStroke(new BasicStroke(1.25f, BasicStroke.JOIN_BEVEL, BasicStroke.JOIN_MITER));
		QuadCurve2D.Double eb1 = new QuadCurve2D.Double();
		start = new Point2D.Double(212, 258);
		control = new Point2D.Double(228, 264);
		end = new Point2D.Double(237, 276);
		eb1.setCurve(start, control, end);
		g2.draw(eb1);

		start = new Point2D.Double(159, 227);
		control = new Point2D.Double(200, 230);
		end = new Point2D.Double(232, 255);
		eb1.setCurve(start, control, end);
		g2.draw(eb1);

		start = new Point2D.Double(308, 255);
		control = new Point2D.Double(317, 240);
		end = new Point2D.Double(334, 235);
		eb1.setCurve(start, control, end);
		g2.draw(eb1);

		start = new Point2D.Double(294, 244);
		control = new Point2D.Double(320, 210);
		end = new Point2D.Double(370, 200);
		eb1.setCurve(start, control, end);
		g2.draw(eb1);
	}

	private Area generatePoligon(int xPoints[], int yPoints[]) {
		GeneralPath filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		filledPolygon.moveTo(xPoints[0], yPoints[0]);
		for (int index = 1; index < xPoints.length; index++) {
			filledPolygon.lineTo(xPoints[index], yPoints[index]);
		}
		filledPolygon.closePath();
		Area area = new Area(filledPolygon);
		return area;
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setVisible(true);
		window.setTitle("Hatsune Miku :D");

		int top = window.getInsets().top;
		int left = window.getInsets().left;
		int right = window.getInsets().right;
		int bottom = window.getInsets().bottom;

		window.setSize(600 + top + bottom, 600 + left + right);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Miku hatsuneMiku = new Miku();
		window.add(hatsuneMiku);
	}
}
