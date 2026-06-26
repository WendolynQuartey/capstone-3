# 🏬 Wu's Kloset
An e-commerce app named `Wu's Kloset` where admin and user functionality is separated. 
Users can only access read routes while Admins can access post, delete, and update routes. 
It also includes a colorful front-end that is sleek and colorful.

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

## Challenges
I struggled a bit with pushing myself to do the bonuses. After I completed the MVP, I decided to focus on other assignments and didn't really look back until today. 
Every time I looked at the phase 3 my brain kind of just went blank and I told myself I would come back to it and never did. I'm not sure if there's a coding version of writer's block, but I definitely had it. 
I was definitely too laid back for this project and I wish I did way more. I also had some bugs with my authentication controller because of something I added a few days ago

## Next Time...
I will definitely add more functionality to my app. I would also change the clothing products because none of the ones in the template are my style. 
