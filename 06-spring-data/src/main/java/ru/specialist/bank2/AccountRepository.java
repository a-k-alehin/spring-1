package ru.specialist.bank2;

import org.springframework.data.repository.CrudRepository;

// Пример составного ключа

public interface AccountRepository extends CrudRepository<Account, AccountId> {

}
