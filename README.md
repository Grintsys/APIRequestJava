The basics about how to consume an Json API are:

### Step 1: Model the data
Most commonly your service provides its data in either XML or JSON format. There are so many tools to help to create the right model of your API service http://www.jsonschema2pojo.org/, or doing this in the manual way creating a API server with Node JS.

### Step 2: Fetch the data
The Client object is the thing that actually handles all the communication. This usually don't require a special configuration is that simple.

```
    String url = "http://52.229.31.185:8091/getdevices";
        
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            
        } catch (IOException ex) {
            System.out.println("error: "+ex.getMessage());
        }    
    }
```

### Step 3: Consume the data
You should now understand the basics of using JAX-RS client APIs. Now you should manipulate this data into a undertand format in your program with POO objects like this example:

```
String json = EntityUtils.toString(result.getEntity(), "UTF-8");
Gson gson = new Gson();
List<Device> devices = gson.fromJson(json, new TypeToken<List<Device>>(){}.getType());
```
Now your data a manipulable object so you can do everything.

```
devices.forEach((d) -> {
  System.out.printf("Name: %s, Status: %d, UpdateDate: %s \n", d.getName(), d.getStatus(), d.getUpdateDate());
});
```

Thanks

