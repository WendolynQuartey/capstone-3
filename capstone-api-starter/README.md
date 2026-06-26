# 🏬 Wu's Kloset API
A JPA controlled backend API for the app `Wu's Kloset` where admin and user functionality is seperated. Users can only access read routes while Admins can access post, delete, and update routes.

## Routes

### 🗂️ Categories Routes
| Method 	 | Endpoint       	         | Description             	               | CRUD Operation 	 | Roles w/ Access |
|----------|--------------------------|-----------------------------------------|------------------|-----------------|
| POST   	 | /categories     	        | Create new category 	                   | Create         	 | Admin           |
| GET    	 | /categories   	          | Get  all categories         	           | Read           	 | All             |
| GET    	 | /categories/{id} 	       | Get category by ID          	           | Read           	 | All             |
| GET    	 | /{categoryId}/products 	 | Get products by  category ID          	 | Read           	 | All             |
| PUT    	 | /categories/{id} 	       | Update category info     	              | Update         	 | Admin           |
| DELETE 	 | /categories/{id} 	       | Delete category     	                   | Delete         	 | Admin           |

### 👚 Products Routes
| Method 	 | Endpoint       	 | Description             	              | CRUD Operation 	 | Roles w/ Access |
|----------|------------------|----------------------------------------|------------------|-----------------|
| POST   	 | /products     	  | Create new products 	                  | Create         	 | Admin           |
| GET    	 | /products   	    | Get  all products w/ filters         	 | Read           	 | All             |
| GET    	 | /products/{id} 	 | Get product by ID          	           | Read           	 | All             |
| PUT    	 | /prodcuts/{id} 	 | Update product info     	              | Update         	 | Admin           |
| DELETE 	 | /products/{id} 	 | Delete product     	                   | Delete         	 | Admin           |


## Favorite Line 