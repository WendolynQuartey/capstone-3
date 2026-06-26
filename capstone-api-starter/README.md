# 🚊 Live-Line API
A JPA controlled backend API for the app `Wu's Kloset` where admin and user functionality is seperated. Users can only read categories while Admins can post, delete, and update categories.

## Paths

### 👤 Categories Routes
| Method 	 | Endpoint       	         | Description             	               | CRUD Operation 	   | Roles w/ Access |
|----------|--------------------------|-----------------------------------------|--------------------|-----------------|
| POST   	 | /categories     	        | Create new category 	                   | Create         	   | Admin           |
| GET    	 | /categories   	          | Get  all categories         	           | Create           	 | All             |
| GET    	 | /categories/{id} 	       | Get category by ID          	           | Read           	   | All             |
| GET    	 | /{categoryId}/products 	 | Get products by  category ID          	 | Read           	   | All             |
| PUT    	 | /categories/{id} 	       | Update category info     	              | Update         	   | Admin           |
| DELETE 	 | /categories/{id} 	       | Delete category     	                   | Delete         	   | Admin           |

### ⭐️ Products Routes
| Method 	| Endpoint       	     | Description             	| CRUD Operation 	|
|--------	|----------------------|-------------------------	|----------------	|
| POST   	| /products     	      | Creates a new favorite location	| Create         	|
| GET    	| /api/favorites     	 | Get all the user's favorite locations        	| Read           	|
| GET    	| /api/favorites/:id 	 | Get location by ID          	| Read           	|
| PUT    	| /api/favorites/:id 	 | Update favorite location information     	| Update         	|
| DELETE 	| /api/favorites/:id 	 | Delete favorite location    	| Delete         	|