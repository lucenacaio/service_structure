package br.com.lucenacaio.structure.exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(int id){
        super("Category not found ID=" + id);
    }

}
