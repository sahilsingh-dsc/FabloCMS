package com.myfablo.cms.module_menu_sync.contract_get_sub_category;

import com.myfablo.cms.module_menu_sync.models.sub_category.get.MenuSubCategoryResponse;

public interface GetSubCategoryInterface {

    void onContractProgress();
    void onContractResponse(MenuSubCategoryResponse menuSubCategoryResponse);
    void onContractNotFound();
    void onContractFailure();

}
