package kodlamaio.northwind.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity// database katmanı
@Table(name="products")// veri tabanında hangi tabloya denk geldiği
@NoArgsConstructor // boş concruoctor oluşturmak için
@AllArgsConstructor // otomatik  concruoctor için
public class Product {
	@Id// primary key belirlemek için
	@GeneratedValue(strategy = GenerationType.IDENTITY)// otomatik arttırılıyor id
	@Column(name="product_id")// tabloda hangi stüna denk geliyor
	private int id;
	
	//@Column(name="category_id")ilişkilendirildi
	//private int categoryId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()// ilişikelndirme satırı
	@JoinColumn(name="category_id")
	private Category category;
	

}
