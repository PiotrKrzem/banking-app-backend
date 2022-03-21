
package bank.app.repository;
import bank.app.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProviderRepository extends MongoRepository<ClientEntity, String> {
}
