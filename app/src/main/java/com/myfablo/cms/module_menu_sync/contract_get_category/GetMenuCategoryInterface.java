package com.myfablo.cms.module_menu_sync.contract_get_category;

import com.myfablo.cms.module_menu_sync.models.category.get.Item;

import java.util.List;

public interface GetMenuCategoryInterface {

    void onContractProgress();
    void onContractResponse(List<Item> items);
    void onContractNotFound();
    void onContractFailure();

}
