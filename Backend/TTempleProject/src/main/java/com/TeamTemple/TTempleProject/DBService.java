package com.TeamTemple.TTempleProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class DBService {

	/** {
    "orderNumber": "50",
    "name": "Melvin",
    "phoneNumber": "2222222222",
    "restaurant": "Burger King",
    "pickup": "10:30 A.M",
    "arrival": "11:00 A.M",
    "location": "Building 8",
    "customers": {}
	}
	 */
	public String createOrder(Order order) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("all_orders")
				.document(order.getOrderNumber()).set(order);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	// api/join?documentId=10&phone=1111111111&customer=Andy&customer=Burger&customer=Fries
	public String joinOrder(String documentId, String phone, List<String> customer) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
		DocumentReference documentReference = dbFirestore.collection("all_orders").document(documentId);
		
		Map<String, Object> updates1 = new HashMap<>();
		Map<String, Object> updates2 = new HashMap<>();
		
		updates2.put(phone, customer);
		updates1.put("customers", updates2);
		
		// Update the customers map and merge with existing data
		ApiFuture<WriteResult> writeResult = documentReference.set(updates1, SetOptions.merge());
		
		return writeResult.get().getUpdateTime().toString();

	}

	// api/get?documentId=10
	public Order getOrder(String documentId) throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();

		// Get the document reference and snapshot
		DocumentReference documentReference = dbFirestore.collection("all_orders").document(documentId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();

		// Get document back from ApiFuture
		DocumentSnapshot document = future.get();
		Order order;

		// Convert to object and send to user
		if (document.exists()) {
			order = document.toObject(Order.class);
			return order;
		}
		return null;
	}
	
	// api/getAll
	public List<Order> getAllOrders() throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();

		ApiFuture<QuerySnapshot> future = dbFirestore.collection("all_orders").get();

		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		List<Order> orders = new ArrayList<>();

		if (!documents.isEmpty()) {
			for (QueryDocumentSnapshot document : documents) {
				orders.add(document.toObject(Order.class));
			}
			return orders;
		}
		return null;
	}

	// Method to get all orders that user created
	// api/getCreated?phone=1111111111
	public List<Order> getCreatedOrders(String phone)
			throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();

		// Create a reference to the all_orders collection
		CollectionReference allOrders = dbFirestore.collection("all_orders");

		// Create a query against the collection.
		Query query = allOrders.whereEqualTo("phoneNumber", phone);

		// Retrieve query results asynchronously using query.get()
		ApiFuture<QuerySnapshot> querySnapshot = query.get();

		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		List<Order> orders = new ArrayList<>();

		if (!documents.isEmpty()) {
			for (QueryDocumentSnapshot document : documents) {
				orders.add(document.toObject(Order.class));
			}
			return orders;
		}
		return null;
	}

	// Method to get all orders that user joined
	// api/getJoined?phone=1111111111
	public List<Order> getJoinedOrders(String phone)
			throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
		// Create a reference to the all_orders collection
		CollectionReference allOrders = dbFirestore.collection("all_orders");

		// Create a query against the collection.
		Query query = allOrders.whereNotEqualTo("customers."+ phone, null);

		// Retrieve query results asynchronously using query.get()
		ApiFuture<QuerySnapshot> querySnapshot = query.get();

		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		List<Order> orders = new ArrayList<>();

		// Convert to object and send to user
		if (!documents.isEmpty()) {
			for (QueryDocumentSnapshot document : documents) {
				orders.add(document.toObject(Order.class));
			}
			return orders;
		}
		return null;
	}

//	// Get list of customers that are in your order
//	// DocumentId will be concatenation of Name+PhoneNumber
//	// Not necessary
//	public Map<String, Object> getCustomers(String namePhone) throws InterruptedException, ExecutionException {
//		// Connect to Firebase and Firestore client
//		Firestore dbFirestore = FirestoreClient.getFirestore();
//
//		// Get the document reference and snapshot
//		DocumentReference documentReference = dbFirestore.collection("your_customers").document(namePhone);
//		ApiFuture<DocumentSnapshot> future = documentReference.get();
//
//		// Get document back from ApiFuture
//		DocumentSnapshot document = future.get();
//
//		// Convert to object and send to user
//		if (document.exists()) {
//			return document.getData();
//		}
//		return null;
//	}

	public String deleteOrder(String documentId) throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();

		// Get the document reference and snapshot
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("all_orders").document(documentId).delete();
		
		return "Successfully deleted " + documentId;
	}
}
