package com.myfablo.cms.module_menu_sync.contract_get_addons;

import com.myfablo.cms.module_menu_sync.models.addons.product.ProductAddonsResponse;

public interface GetProductAddonsInterface {

    void onContractProgress();

    void onContractResponse(ProductAddonsResponse productAddonsResponse);

    void onContractNotFound();

    void onContractFailure();
}
