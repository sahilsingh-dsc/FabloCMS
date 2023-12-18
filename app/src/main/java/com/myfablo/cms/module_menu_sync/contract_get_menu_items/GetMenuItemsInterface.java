package com.myfablo.cms.module_menu_sync.contract_get_menu_items;

import com.myfablo.cms.module_menu_sync.models.menu_items.MenuItemsResponse;

public interface GetMenuItemsInterface {

    void onContractProgress();
    void onContractResponse(MenuItemsResponse menuItemsResponse);
    void onContractNotFound();
    void onContractFailure();


}
