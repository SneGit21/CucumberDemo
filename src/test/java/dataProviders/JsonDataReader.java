package dataProviders;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.List;
	import com.google.gson.Gson;
	import managers.FileReaderManager;
	import testDataTypes.Product;;
	
public class JsonDataReader {
	private final String productFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "products.json";
	private List<Product> productList;
	
	public JsonDataReader(){
		productList = getProductData();
	}
	
	private List<Product> getProductData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(productFilePath));
			Product[] products = gson.fromJson(bufferReader, Product[].class);
			return Arrays.asList(products);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + productFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	/*public final Product getProductByName(String productName){
			 return productList.stream().filter(x -> x.product.equalsIgnoreCase(productName)).findAny().get();
	}*/
	
	public final Product getProductByName(String productName){
		for(Product products : productList) {
			if(products.product.equalsIgnoreCase(productName)) return products;
		}
		return null;
	}
	

}