/*
 * Selling Partner API for FBA Inbound Eligibilty
 * With the FBA Inbound Eligibility API, you can build applications that let sellers get eligibility previews for items before shipping them to Amazon's fulfillment centers. With this API you can find out if an item is eligible for inbound shipment to Amazon's fulfillment centers in a specific marketplace. You can also find out if an item is eligible for using the manufacturer barcode for FBA inventory tracking. Sellers can use this information to inform their decisions about which items to ship Amazon's fulfillment centers.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.erp.sdk.oms.amz.spapi.api;

import com.erp.sdk.oms.amz.spapi.SellingPartnerAPIAA.*;
import com.erp.sdk.oms.amz.spapi.client.*;
import com.erp.sdk.oms.amz.spapi.model.fbainboundeligibility.GetItemEligibilityPreviewResponse;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
public class FbaInboundEligibilityApi {
    private ApiClient apiClient;

    FbaInboundEligibilityApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FbaInboundEligibilityApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getItemEligibilityPreview
     * @param asin The ASIN of the item for which you want an eligibility preview. (required)
     * @param program The program that you want to check eligibility against. (required)
     * @param marketplaceIds The identifier for the marketplace in which you want to determine eligibility. Required only when program&#x3D;INBOUND. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public Call getItemEligibilityPreviewCall(String asin, String program, List<String> marketplaceIds, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/fba/inbound/v1/eligibility/itemPreview";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (marketplaceIds != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "marketplaceIds", marketplaceIds));
        if (asin != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("asin", asin));
        if (program != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("program", program));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private Call getItemEligibilityPreviewValidateBeforeCall(String asin, String program, List<String> marketplaceIds, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'asin' is set
        if (asin == null) {
            throw new ApiException("Missing the required parameter 'asin' when calling getItemEligibilityPreview(Async)");
        }
        
        // verify the required parameter 'program' is set
        if (program == null) {
            throw new ApiException("Missing the required parameter 'program' when calling getItemEligibilityPreview(Async)");
        }
        

        Call call = getItemEligibilityPreviewCall(asin, program, marketplaceIds, progressListener, progressRequestListener);
        return call;

    }

    /**
     * 
     * This operation gets an eligibility preview for an item that you specify. You can specify the type of eligibility preview that you want (INBOUND or COMMINGLING). For INBOUND previews, you can specify the marketplace in which you want to determine the item&#39;s eligibility.  **Usage Plan:**  | Rate (requests per second) | Burst | | ---- | ---- | | 1 | 1 |  For more information, see \&quot;Usage Plans and Rate Limits\&quot; in the Selling Partner API documentation.
     * @param asin The ASIN of the item for which you want an eligibility preview. (required)
     * @param program The program that you want to check eligibility against. (required)
     * @param marketplaceIds The identifier for the marketplace in which you want to determine eligibility. Required only when program&#x3D;INBOUND. (optional)
     * @return GetItemEligibilityPreviewResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetItemEligibilityPreviewResponse getItemEligibilityPreview(String asin, String program, List<String> marketplaceIds) throws ApiException {
        ApiResponse<GetItemEligibilityPreviewResponse> resp = getItemEligibilityPreviewWithHttpInfo(asin, program, marketplaceIds);
        return resp.getData();
    }

    /**
     * 
     * This operation gets an eligibility preview for an item that you specify. You can specify the type of eligibility preview that you want (INBOUND or COMMINGLING). For INBOUND previews, you can specify the marketplace in which you want to determine the item&#39;s eligibility.  **Usage Plan:**  | Rate (requests per second) | Burst | | ---- | ---- | | 1 | 1 |  For more information, see \&quot;Usage Plans and Rate Limits\&quot; in the Selling Partner API documentation.
     * @param asin The ASIN of the item for which you want an eligibility preview. (required)
     * @param program The program that you want to check eligibility against. (required)
     * @param marketplaceIds The identifier for the marketplace in which you want to determine eligibility. Required only when program&#x3D;INBOUND. (optional)
     * @return ApiResponse&lt;GetItemEligibilityPreviewResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetItemEligibilityPreviewResponse> getItemEligibilityPreviewWithHttpInfo(String asin, String program, List<String> marketplaceIds) throws ApiException {
        Call call = getItemEligibilityPreviewValidateBeforeCall(asin, program, marketplaceIds, null, null);
        Type localVarReturnType = new TypeToken<GetItemEligibilityPreviewResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * This operation gets an eligibility preview for an item that you specify. You can specify the type of eligibility preview that you want (INBOUND or COMMINGLING). For INBOUND previews, you can specify the marketplace in which you want to determine the item&#39;s eligibility.  **Usage Plan:**  | Rate (requests per second) | Burst | | ---- | ---- | | 1 | 1 |  For more information, see \&quot;Usage Plans and Rate Limits\&quot; in the Selling Partner API documentation.
     * @param asin The ASIN of the item for which you want an eligibility preview. (required)
     * @param program The program that you want to check eligibility against. (required)
     * @param marketplaceIds The identifier for the marketplace in which you want to determine eligibility. Required only when program&#x3D;INBOUND. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public Call getItemEligibilityPreviewAsync(String asin, String program, List<String> marketplaceIds, final ApiCallback<GetItemEligibilityPreviewResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        Call call = getItemEligibilityPreviewValidateBeforeCall(asin, program, marketplaceIds, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetItemEligibilityPreviewResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    public static class Builder {
        private AWSAuthenticationCredentials awsAuthenticationCredentials;
        private LWAAuthorizationCredentials lwaAuthorizationCredentials;
        private String endpoint;
        private LWAAccessTokenCache lwaAccessTokenCache;
        private Boolean disableAccessTokenCache = false;
        private AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider;

        public Builder awsAuthenticationCredentials(AWSAuthenticationCredentials awsAuthenticationCredentials) {
            this.awsAuthenticationCredentials = awsAuthenticationCredentials;
            return this;
        }

        public Builder lwaAuthorizationCredentials(LWAAuthorizationCredentials lwaAuthorizationCredentials) {
            this.lwaAuthorizationCredentials = lwaAuthorizationCredentials;
            return this;
        }

        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }
        
        public Builder lwaAccessTokenCache(LWAAccessTokenCache lwaAccessTokenCache) {
            this.lwaAccessTokenCache = lwaAccessTokenCache;
            return this;
        }
		
	   public Builder disableAccessTokenCache() {
            this.disableAccessTokenCache = true;
            return this;
        }
        
        public Builder awsAuthenticationCredentialsProvider(AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider) {
            this.awsAuthenticationCredentialsProvider = awsAuthenticationCredentialsProvider;
            return this;
        }
        

        public FbaInboundEligibilityApi build() {
            if (awsAuthenticationCredentials == null) {
                throw new RuntimeException("AWSAuthenticationCredentials not set");
            }

            if (lwaAuthorizationCredentials == null) {
                throw new RuntimeException("LWAAuthorizationCredentials not set");
            }

            if (StringUtil.isEmpty(endpoint)) {
                throw new RuntimeException("Endpoint not set");
            }

            AWSSigV4Signer awsSigV4Signer;
            if ( awsAuthenticationCredentialsProvider == null) {
                awsSigV4Signer = new AWSSigV4Signer(awsAuthenticationCredentials);
            }
            else {
                awsSigV4Signer = new AWSSigV4Signer(awsAuthenticationCredentials,awsAuthenticationCredentialsProvider);
            }
            
            LWAAuthorizationSigner lwaAuthorizationSigner = null;            
            if (disableAccessTokenCache) {
                lwaAuthorizationSigner = new LWAAuthorizationSigner(lwaAuthorizationCredentials);
            }
            else {
                if (lwaAccessTokenCache == null) {
                    lwaAccessTokenCache = new LWAAccessTokenCacheImpl();                  
                 }
                 lwaAuthorizationSigner = new LWAAuthorizationSigner(lwaAuthorizationCredentials,lwaAccessTokenCache);
            }

            return new FbaInboundEligibilityApi(new ApiClient()
                .setAWSSigV4Signer(awsSigV4Signer)
                .setLWAAuthorizationSigner(lwaAuthorizationSigner)
                .setBasePath(endpoint));
        }
    }
}
