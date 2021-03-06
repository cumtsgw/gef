/*******************************************************************************
 * Copyright (c) 2017 itemis AG and others.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthias Wienand (itemis AG) - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.gef.mvc.fx.ui.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.action.IAction;

/**
 * The {@link ZoomActionGroup} is an {@link AbstractViewerActionGroup} that
 * combines {@link ZoomOutAction}, {@link ZoomScaleContributionItem},
 * {@link ZoomInAction}, {@link ZoomResetAction}, and
 * {@link ZoomComboContributionItem}. Upon construction, you can add additional
 * actions that are put into the {@link ZoomComboContributionItem} (see
 * {@link #ZoomActionGroup(IAction...)}.
 *
 * @author mwienand
 *
 */
public class ZoomActionGroup extends AbstractViewerActionGroup {

	private ZoomComboContributionItem zoomCombo;

	/**
	 * Constructs a new {@link ZoomActionGroup} and adds the given additional
	 * actions to the {@link ZoomComboContributionItem} that is contained in
	 * this action group.
	 *
	 * @param additionalComboItems
	 *            The additional actions for the
	 *            {@link ZoomComboContributionItem}.
	 */
	public ZoomActionGroup(IAction... additionalComboItems) {
		zoomCombo = new ZoomComboContributionItem(additionalComboItems);
	}

	@Override
	public List<IViewerDependent> createViewerDependents() {
		List<IViewerDependent> dependents = new ArrayList<>(Arrays.asList(
				new ZoomOutAction(), new ZoomScaleContributionItem(),
				new ZoomInAction(), new ZoomResetAction()));
		if (zoomCombo != null) {
			dependents.add(zoomCombo);
		}
		return dependents;
	}
}
