package br.llslucas.condominio.persistence.mapper;

public interface Mapper<T, K> {
	public T toModel();
	public K toDTO();
}
