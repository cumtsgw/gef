/*******************************************************************************
 * Copyright (c) 2011, 2015 itemis AG and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Matthias Wienand (itemis AG) - initial API and implementation
 *     
 *******************************************************************************/
package org.eclipse.gef.geometry.examples.intersection;

import org.eclipse.gef.geometry.convert.swt.Geometry2SWT;
import org.eclipse.gef.geometry.planar.Ellipse;
import org.eclipse.gef.geometry.planar.IGeometry;
import org.eclipse.gef.geometry.planar.Line;
import org.eclipse.gef.geometry.planar.Point;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;

/**
 * Simple example demonstrating the intersection of an {@link Ellipse} and a
 * {@link Line}.
 * 
 * @author Matthias Wienand (matthias.wienand@itemis.de)
 * 
 */
public class EllipseLineIntersection
		extends AbstractEllipseIntersectionExample {

	public static void main(String[] args) {
		new EllipseLineIntersection();
	}

	public EllipseLineIntersection() {
		super("Ellipse/Line Intersection");
	}

	@Override
	protected Point[] computeIntersections(IGeometry g1, IGeometry g2) {
		return ((Ellipse) g1).getIntersections((Line) g2);
	}

	@Override
	protected AbstractControllableShape createControllableShape2(
			Canvas canvas) {
		return new AbstractControllableShape(canvas) {
			@Override
			public void createControlPoints() {
				addControlPoint(new Point(100, 100));
				addControlPoint(new Point(300, 300));
			}

			@Override
			public Line createGeometry() {
				Point[] points = getControlPoints();
				return new Line(points[0], points[1]);
			}

			@Override
			public void drawShape(GC gc) {
				Line line = createGeometry();
				gc.drawPolyline(Geometry2SWT.toSWTPointArray(line));
			}
		};
	}
}
