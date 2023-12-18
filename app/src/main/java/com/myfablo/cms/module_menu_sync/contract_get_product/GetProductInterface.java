package com.myfablo.cms.module_menu_sync.contract_get_product;

import com.myfablo.cms.module_menu_sync.models.product.MenuProductResponse;

public interface GetProductInterface {

    void onContractProgress();
    void onContractResponse(MenuProductResponse menuProductResponse);
    void onContractNotFound();
    void onContractFailure();

}
