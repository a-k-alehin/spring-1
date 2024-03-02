package ru.specialist.bank;

import org.springframework.data.repository.CrudRepository;

// Пример составного ключа

public interface AccountRepository extends CrudRepository<Account, AccountId> {

}
