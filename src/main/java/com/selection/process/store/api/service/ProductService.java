package com.selection.process.store.api.service;

import com.selection.process.store.api.dto.GenericResponseDTO;
import com.selection.process.store.api.dto.ProductDTO;
import com.selection.process.store.api.projection.ProductMaxProjection;
import com.selection.process.store.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
    * Lista todos os produtos registrados no banco de dados
     * @return uma lista com os dados de todos os produtos cadastrados no banco.
    */
    public List<ProductMaxProjection> findAll(){
        return null;
    }

    /**
    * Busca um determinado produto pelo seu identificador único (id).
    * @param productId se refere ao Id do produto procurado.
     * O Id de um determinado produto pode ser encontrado através de {@link ProductService#findAll()}.
    * @return o objeto que contém os dados do respectivo produto.
     * @throws ResourceNotFoundException caso nenhum produto seja encontrado pelo id fornecido.
    **/
    public ProductDTO findById(long productId){
        return null;
    }

    /**
    * Adiciona um novo produto ao banco de dados.
    * @param dto se refere ao objeto com os dados do novo produto.
     * @return o objeto criado, com seus respectivos dados.
     * @throws EmptyFieldException caso o nome esteja vazio.
     * @throws NegativeValueException caso o preço ou a quantidade seja um número negativo.
     */
    public ProductDTO create(ProductDTO dto){
        return null;
    }

    /**
     * Atualiza totalmente ou parcialmente um determinado produto registrado no banco de dados.
     * @param dto se refere ao objeto com os dados do produto a ser atualizado.
     * @return o novo produto atualizado
     * @throws ResourceNotFoundException caso o produto do id fornecido não seja encontrado.
     * @throws NegativeValueException caso o preço ou a quantidade seja um número negativo.
     * @throws EmptyFieldException caso o nome esteja vazio.
     */
    public ProductDTO update(ProductDTO dto){
        return null;
    }

    /**
     * Exclui, pelo id, um produto do banco de dados.
     * @param productId se refere ao Id do produto a ser deletado.
     * @return uma entidade de resposta que confirma a deleção do produto posteriormente.
     * @throws ResourceNotFoundException caso o produto do id fornecido não seja encontrado
     */
    public ResponseEntity<GenericResponseDTO> deleteById(long productId){
        return null;
    }

    /**
     * Pesquisa todos os produtos que correspondem parcialmente com o nome fornecido.
     * @param partialName é o nome que será usado como parametro do resultado dos produtos.
     * @return uma lista com os determinados produtos que contém parte desse nome.
     * @throws ResourceNotFoundException caso nenhum produto seja encontrado com o nome fornecido.
     */
    public List<ProductMaxProjection> searchByPartialname(String partialName){
        return null;
    }

}
