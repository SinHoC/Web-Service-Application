public class test 
{

	public static void main(String args[]) 
	{
		String simpJson = "{\n" + "	\"item\":\"food\"," + "	\"price\":\"67.00\" " + "}";

		ObjectMapper map = new ObjectMapper();
		JsonNode jsonNode = map.readTree(simpJson.getBytes());
		String item = jsonNode.get("item").textValue();
		System.out.println("Item: " + item);
		System.out.println("Price: " + jsonNode.get("price").textValue());
	}
}