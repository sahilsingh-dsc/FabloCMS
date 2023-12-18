package com.myfablo.cms.module_menu_sync.contract_get_variants;

import com.myfablo.cms.module_menu_sync.models.variants.ProductVariantResponse;

public interface GetProductVariantsInterface {

    void onContractProgress();

    void onContractResponse(ProductVariantResponse productVariantResponse);

    void onContractNotFound();

    void onContractFailure();

}
