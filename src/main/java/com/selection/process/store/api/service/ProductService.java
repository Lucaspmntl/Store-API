package com.selection.process.store.api.service;

import com.selection.process.store.api.dto.ProductMinDTO;
import com.selection.process.store.api.dto.UpdateProductDTO;
import com.selection.process.store.api.dto.ProductDTO;
import com.selection.process.store.api.entity.Product;
import com.selection.process.store.api.exception.ResourceNotFoundException;
import com.selection.process.store.api.projection.ProductProjection;
import com.selection.process.store.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
    * Lista todos os produtos registrados no banco de dados
     * @return uma lista com os dados de todos os produtos cadastrados no banco.
    */
    @Transactional
    public List<ProductDTO> findAll(){
        List<Product> list = productRepository.findAll();
        List<ProductDTO> dto = list.stream()
                .map(obj -> new ProductDTO(obj))
                .toList();

        return dto;
    }

    /**
    * Busca um determinado produto pelo seu identificador único (id).
    * @param id se refere ao Id do produto procurado.
     * O Id de um determinado produto pode ser encontrado através de {@link ProductService#findAll()}.
    * @return o objeto que contém os dados do respectivo produto.
     * @throws ResourceNotFoundException caso nenhum produto seja encontrado pelo id fornecido.
    **/
    @Transactional
    public ProductDTO findById(long id){
        Product product = productRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Produto com id " + id +  " não encontrado."));

        return new ProductDTO(product);
    }

    /**
    * Adiciona um novo produto ao banco de dados.
    * @param dto se refere ao objeto com os dados do novo produto.
     * @return o objeto criado, com seus respectivos dados.
     * @throws MethodArgumentNotValidException (Bean Validation) caso o nome esteja vazio.
     * @throws MethodArgumentNotValidException (Bean Validation) caso o preço ou a quantidade seja um número negativo.
     */
    @Transactional
    public ProductDTO create(ProductMinDTO dto){
        Product registeredProduct = productRepository.save(new Product(dto));
        return new ProductDTO(registeredProduct);
    }

    /**
     * Atualiza totalmente ou parcialmente um determinado produto registrado no banco de dados.
     * @param dto se refere ao objeto com os dados do produto a ser atualizado.
     * @return o novo produto atualizado
     * @throws ResourceNotFoundException caso o produto do id fornecido não seja encontrado.
     * @throws MethodArgumentNotValidException (Bean Validation) caso o preço ou a quantidade seja um número negativo.
     * @throws MethodArgumentNotValidException (Bean Validation) caso o nome esteja vazio.
     */
    @Transactional
    public ProductDTO update(UpdateProductDTO dto, long id){
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com id " + id + " não encontrado."));

        if (dto.getDescription() != null)
            updateProduct.setDescription(dto.getDescription());

        if (dto.getName() != null)
            updateProduct.setName(dto.getName());

        if (dto.getPrice() != null)
            updateProduct.setPrice(dto.getPrice());

        if (dto.getQuantity() != null)
            updateProduct.setQuantity(dto.getQuantity());

        return new ProductDTO(productRepository.save(updateProduct));
    }

    /**
     * Exclui, pelo id, um produto do banco de dados.
     * @param id se refere ao Id do produto a ser deletado.
     * @return uma entidade de resposta que confirma a deleção do produto posteriormente.
     * @throws ResourceNotFoundException caso o produto do id fornecido não seja encontrado
     */
    @Transactional
    public ProductDTO deleteById(long id){
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com id " + id + " não encontrado."));

        productRepository.deleteById(id);
        return new ProductDTO(deletedProduct);
    }

    /**
     * Pesquisa todos os produtos que correspondem parcialmente com o nome fornecido.
     * @param partialName é o nome que será usado como parametro do resultado dos produtos.
     * @return uma lista com os determinados produtos que contém parte desse nome.
     * @throws ResourceNotFoundException caso nenhum produto seja encontrado com o nome fornecido.
     */
    public List<ProductDTO> searchByPartialName(String partialName){
        List<ProductProjection> productsProjection = productRepository.searchByPartialName(partialName);

        if (productsProjection.isEmpty()){
            throw new ResourceNotFoundException("Não foram encontrados produtos com o nome " + partialName);
        }

        return productsProjection.stream()
                .map(obj -> new ProductDTO(obj))
                .toList();
    }

}
