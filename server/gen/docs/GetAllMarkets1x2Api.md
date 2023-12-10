# GetAllMarkets1x2Api

All URIs are relative to *https://server*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllMarkets1x2**](GetAllMarkets1x2Api.md#getAllMarkets1x2) | **GET** /api/bets | GET api/bets


<a name="getAllMarkets1x2"></a>
# **getAllMarkets1x2**
> List&lt;Market1x2DTO&gt; getAllMarkets1x2()

GET api/bets

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GetAllMarkets1x2Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://server");

    GetAllMarkets1x2Api apiInstance = new GetAllMarkets1x2Api(defaultClient);
    try {
      List<Market1x2DTO> result = apiInstance.getAllMarkets1x2();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GetAllMarkets1x2Api#getAllMarkets1x2");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Market1x2DTO&gt;**](Market1x2DTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

