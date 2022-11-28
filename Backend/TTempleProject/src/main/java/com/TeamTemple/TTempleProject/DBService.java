package com.TeamTemple.TTempleProject;

import java.util.ArrayList;
import java.util.List;
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
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class DBService {
	
	public String createOrder(Order order) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("all_orders").document(order.getOrderNumber()).set(order);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

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
		if(document.exists()) {
			order = document.toObject(Order.class);
			return order;
		}
		return null;
	}
	
	public List<Order> getAllOrders() throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();
	
		ApiFuture<QuerySnapshot> future = dbFirestore.collection("all_orders").get();
		
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		List<Order> orders = new ArrayList<>();
		
		if(!documents.isEmpty()) {
			for(QueryDocumentSnapshot document : documents) {
				orders.add(document.toObject(Order.class));
			}
			return orders;
		}
		return null;
	}
	
	// Method to get all orders that user created
	public List<Order> getCreatedOrders(String name, String phoneNumber) throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
		// Create a reference to the all_orders collection
		CollectionReference allOrders = dbFirestore.collection("all_orders");
		
		// Create a query against the collection.
		Query query = allOrders.whereEqualTo("name", name).whereEqualTo("phoneNumber", phoneNumber);
		
		// Retrieve query results asynchronously using query.get()
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		
		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		List<Order> orders = new ArrayList<>();
		
		if(!documents.isEmpty()) {
			for(QueryDocumentSnapshot document : documents) {
				orders.add(document.toObject(Order.class));
			}
			return orders;
		}
		return null;
	}
	
	// Method to get all orders that user created
	public List<Order> getJoinedOrders(String name, String phoneNumber) throws InterruptedException, ExecutionException {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
		// Create a reference to the all_orders collection
		CollectionReference allOrders = dbFirestore.collection("all_orders");
		
		// Create a query against the collection.
		Query query = allOrders.whereEqualTo("name", name).whereEqualTo("phoneNumber", phoneNumber);
		
		// Retrieve query results asynchronously using query.get()
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		
		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		List<Order> orders = new ArrayList<>();
		
		if(!documents.isEmpty()) {
			for(QueryDocumentSnapshot document : documents) {
				orders.add(document.toObject(Order.class));
			}
			return orders;
		}
		return null;
	}
	
	public String deleteOrder(String documentId) {
		// Connect to Firebase and Firestore client
		Firestore dbFirestore = FirestoreClient.getFirestore();
		
		// Get the document reference and snapshot
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("all_orders").document(documentId).delete();
		return "Successfully deleted " + documentId;
	}
}
