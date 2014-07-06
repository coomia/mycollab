/**
 * This file is part of mycollab-mobile.
 *
 * mycollab-mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-mobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-mobile.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.mobile.module.crm.view.account;

import com.esofthead.mycollab.eventmanager.EventBus;
import com.esofthead.mycollab.mobile.module.crm.events.AccountEvent;
import com.esofthead.mycollab.mobile.ui.AbstractListViewComp;
import com.esofthead.mycollab.mobile.ui.AbstractPagedBeanList;
import com.esofthead.mycollab.mobile.ui.MobileNavigationButton;
import com.esofthead.mycollab.module.crm.domain.SimpleAccount;
import com.esofthead.mycollab.module.crm.domain.criteria.AccountSearchCriteria;
import com.esofthead.mycollab.module.crm.i18n.AccountI18nEnum;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.mvp.ViewComponent;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.ui.Component;

/**
 * 
 * @author MyCollab Ltd.
 * @since 3.0
 * 
 */

@ViewComponent
public class AccountListViewImpl extends
		AbstractListViewComp<AccountSearchCriteria, SimpleAccount> implements
		AccountListView {

	private static final long serialVersionUID = -500810154594390148L;

	public AccountListViewImpl() {
		super();

		setCaption(AppContext.getMessage(AccountI18nEnum.VIEW_LIST_TITLE));
	}

	@Override
	protected AbstractPagedBeanList<AccountSearchCriteria, SimpleAccount> createBeanTable() {
		AccountListDisplay accountListDisplay = new AccountListDisplay();
		return accountListDisplay;
	}

	@Override
	protected Component createRightComponent() {
		MobileNavigationButton addAccount = new MobileNavigationButton();
		addAccount.setTargetViewCaption(AppContext
				.getMessage(AccountI18nEnum.VIEW_NEW_TITLE));
		addAccount
				.addClickListener(new NavigationButton.NavigationButtonClickListener() {
					private static final long serialVersionUID = 1L;

					@Override
					public void buttonClick(
							NavigationButton.NavigationButtonClickEvent arg0) {
						EventBus.getInstance().fireEvent(
								new AccountEvent.GotoAdd(this, null));
					}
				});
		addAccount.setStyleName("add-btn");
		return addAccount;
	}
}