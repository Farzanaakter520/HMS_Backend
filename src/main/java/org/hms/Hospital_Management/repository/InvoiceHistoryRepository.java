package org.hms.Hospital_Management.repository;

import org.hms.Hospital_Management.model.InvoiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface InvoiceHistoryRepository extends JpaRepository<InvoiceHistory, Long> {

    // Find invoice by its invoice number
    Optional<InvoiceHistory> findByInvoiceNumber(String invoiceNumber);

    // Count how many invoices start with a specific prefix (used for generating new invoice number)
    int countByInvoiceNumberStartingWith(String prefix);
}
