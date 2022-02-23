package com.example.demo.tripsapi.test.domain.repo.base;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public class JpaRepositoryFake<T, ID> implements JpaRepository<T, ID> {

  @Override
  public List<T> findAll() {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public List<T> findAll(Sort sort) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public Page<T> findAll(Pageable pageable) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public List<T> findAllById(Iterable<ID> ids) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void deleteById(ID id) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void delete(T entity) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void deleteAllById(Iterable<? extends ID> ids) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void deleteAll(Iterable<? extends T> entities) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void deleteAll() {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> S save(S entity) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> List<S> saveAll(Iterable<S> entities) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public Optional<T> findById(ID id) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public boolean existsById(ID id) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void flush() {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> S saveAndFlush(S entity) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void deleteAllInBatch(Iterable<T> entities) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<ID> ids) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public void deleteAllInBatch() {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public T getOne(ID id) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public T getById(ID id) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> Optional<S> findOne(Example<S> example) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> List<S> findAll(Example<S> example) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> long count(Example<S> example) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T> boolean exists(Example<S> example) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }

  @Override
  public <S extends T, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
    throw new UnsupportedOperationException("The fake implementation is not provided for this method");
  }
}
