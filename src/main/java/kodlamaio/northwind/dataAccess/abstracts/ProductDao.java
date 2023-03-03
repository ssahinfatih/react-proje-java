package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;//CRUD işlemleri için kullanılır.
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;



public interface ProductDao extends JpaRepository<Product,Integer> {
	                                            //Hangi tablo,Primary keyin türü  
	
	Product getByProductName(String productName);//isime göre getirme
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);//isim ve kategori nosuna göre getirme
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);//isim veya kategori nosuna göre getirme
	 
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);//içinde geçiyoırsa getir
	
	List<Product> getByProductNameStartsWith(String productName);//... ile başlayan getir
	
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p ")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	//Category c demek Category classında products ile ilişkilendirilmesi .

}
