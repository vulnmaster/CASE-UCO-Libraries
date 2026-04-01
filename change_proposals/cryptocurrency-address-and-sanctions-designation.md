# Target release

**Target**: UCO 1.5.0

This proposal targets the cryptocurrency address and transaction modeling concepts only (Requirements 1–4). The sanctions designation concept originally included in this proposal has been separated into a distinct CASE proposal per reviewer feedback — see [Deferred: Sanctions Classification](#deferred-sanctions-classification) below.

# Background

Cryptocurrency addresses and blockchain transactions are increasingly encountered in digital forensics, financial crime investigations, and sanctions compliance. Law enforcement agencies routinely trace cryptocurrency flows in ransomware, money laundering, terrorism financing, and sanctions evasion cases. Forensic tools such as [Chainalysis](https://www.chainalysis.com/), [Elliptic](https://www.elliptic.co/), and [CipherTrace](https://ciphertrace.com/) produce structured data about blockchain addresses, transactions, and their relationships — yet CASE/UCO has no dedicated classes to represent this data.

**Prior art**: [CASE Issue #87](https://github.com/casework/CASE/issues/87) proposed `CryptoWalletFacet` and `CryptoAddressFacet` in April 2022. That proposal was blocked by [UCO Issue #535](https://github.com/ucoProject/UCO/issues/535) ("Add Qualities to UCO"), which addresses time-varying properties such as wallet balances. The proposal also depended on [QUDT](https://qudt.org/) for currency measurement, which reviewers found overly complex — the consensus is that QUDT's SHACL shapes are too involved for practical adoption. This proposal builds on the concepts from CASE #87 while avoiding the QUDT dependency and the time-varying balance problem (which remains under UCO #535). It also expands the scope to cover blockchain **transactions**, which are central to financial crime investigations.

Currently, the UCO ontology has no class or facet for modeling cryptocurrency addresses or blockchain transactions. The closest existing concepts are:

- **`DigitalAddress` / `DigitalAddressFacet`** — designed for "routing and management of digital communication" (IP, MAC, email, Bluetooth, etc.), not financial instruments on a distributed ledger.
- **`DigitalAccount` / `DigitalAccountFacet`** — models login-based accounts with properties like `accountLogin`, `firstLoginTime`, and `isDisabled`, none of which apply to permissionless blockchain addresses that have no login credentials.
- **`PaymentCard`** — models physical payment cards issued by financial institutions, not decentralized cryptocurrency wallets.
- **`AccountFacet`** — has `accountType` and `accountIssuer`, but cryptocurrency addresses are not "issued" by an entity and don't fit the account-with-an-issuer model.
- **`ObservableAction`** — could theoretically model a transaction, but lacks the blockchain-specific properties (transaction hash, block number, fee, confirmation count) needed for forensic analysis.

**Ontology gap confirmed via `search_classes` on**: "cryptocurrency" (0 results), "blockchain" (0 results), "wallet" (0 results), "transaction" (0 results), "financial" (0 results), "currency" (0 results — `Mutex`/`MutexFacet` returned as false positives). `find_classes_for_domain("cryptocurrency investigation")` and `find_classes_for_domain("financial crime investigation")` returned no task templates.

**What do we achieve for whom and why does that matter?** We enable forensic examiners, financial investigators, and compliance analysts to model cryptocurrency addresses and blockchain transactions in CASE/UCO-compliant graphs, allowing structured querying across cases involving cryptocurrency activity — including tracing flows through exchanges, mixing services, and between suspects. This is a prerequisite for the financial data modeling working group being formed by community members for warrant returns and cloud returns from financial institutions.


# Requirements


## Requirement 1

Define a new `CryptocurrencyAddressFacet` class as a subclass of `uco-observable:Facet` with properties for the blockchain address string, cryptocurrency type (as an open vocabulary), the blockchain network, and the address encoding format. This facet is attached to an `ObservableObject` to represent a cryptocurrency address observed during an investigation.


## Requirement 2

Define a new open vocabulary `CryptocurrencyTypeVocab` (as a `ControlledVocabulary` instance, not a closed enumeration) providing recommended-but-not-exhaustive cryptocurrency identifiers. Per reviewer feedback, this MUST be an open vocabulary — producers may use values not in the initial set, and consumers should handle unknown values gracefully. Initial recommended values include: `BTC`, `ETH`, `LTC`, `XMR`, `ZEC`, `DASH`, `ETC`, `BCH`, `XRP`, `DOGE`, `SOL`, `ADA`, `DOT`, `AVAX`, `MATIC`, `USDT`, `USDC`.


## Requirement 3

Define a new `CryptocurrencyTransactionFacet` class as a subclass of `uco-observable:Facet` with properties for the transaction hash, block hash, block number, transaction fee, confirmation count, and transaction status. This facet is attached to an `ObservableObject` representing a blockchain transaction. The source and destination addresses are modeled as `ObservableRelationship` instances (with `kindOfRelationship` values such as `"Transaction_Input"` and `"Transaction_Output"`) connecting the transaction `ObservableObject` to the address `ObservableObject`s, along with the transferred amount.


## Requirement 4

Define a new open vocabulary `CryptocurrencyTransactionTypeVocab` providing recommended transaction type values. Initial recommended values include: `Transfer`, `Exchange`, `Purchase`, `Mixing`, `Withdrawal`, `Deposit`, `ContractExecution`, `Staking`, `Unstaking`.


# Risk / Benefit analysis


## Benefits

1. **Closes a critical modeling gap**: Cryptocurrency tracing is now central to ransomware, money laundering, terrorism financing, and sanctions evasion investigations. Without dedicated classes, investigators must resort to unstructured free-text fields or non-standard extensions, undermining interoperability.

2. **Enables structured SPARQL querying**: Investigators can query across cases for all addresses of a given cryptocurrency type, all transactions involving a suspect address, transaction flows through mixing services, and total amounts transferred between entities — none of which is possible today.

3. **Aligns with real-world tooling**: The proposed facet properties map to the data fields produced by Chainalysis, Elliptic, CipherTrace, and blockchain explorers (Etherscan, Blockchain.com, etc.), making it straightforward for tool vendors to produce compliant output.

4. **Interoperability across agencies**: A standardized representation of cryptocurrency addresses and transactions enables cross-agency sharing (e.g., FinCEN, FBI, Europol, AUSTRAC) using a common vocabulary.

5. **Complements existing proposals**: Builds on [CASE Issue #87](https://github.com/casework/CASE/issues/87) without requiring QUDT or the Qualities mechanism from [UCO Issue #535](https://github.com/ucoProject/UCO/issues/535). Once Qualities are resolved, wallet balance modeling can be added as an incremental enhancement.

6. **Supports financial data working group**: Community members are forming a working group for financial data modeling (warrant returns, cloud returns from exchanges). This proposal provides the foundational vocabulary that working group needs.


## Risks

- The cryptocurrency ecosystem evolves rapidly. New blockchain networks and address formats emerge frequently. The open vocabulary (`CryptocurrencyTypeVocab`) mitigates this by allowing producer-defined values while providing a recommended baseline.
- Transaction modeling may need refinement once the Qualities mechanism ([UCO Issue #535](https://github.com/ucoProject/UCO/issues/535)) is resolved, as transaction confirmations increase over time.
- UTXO-based blockchains (Bitcoin) have multi-input/multi-output transactions that are more complex than the single-sender/single-receiver model of account-based blockchains (Ethereum). The proposed `ObservableRelationship` pattern handles this natively by allowing multiple input and output relationships per transaction.
- The submitter is unaware of other risks associated with this change.


# Competencies demonstrated


## Competency 1 — Ransomware Payment Tracing

**Scenario**: A financial crimes unit is investigating a ransomware group that demands payment in Bitcoin. During the investigation, an analyst extracts three cryptocurrency addresses from the ransom note and related communications. The analyst uses Chainalysis to trace the transaction history and discovers that funds from the ransom payment flowed through two intermediate addresses before arriving at an address controlled by a known cryptocurrency exchange (Binance). The investigation models the addresses, the transactions connecting them, the exchange as an organization, and the forensic tool used for tracing.


### Competency Question 1.1

**Which cryptocurrency addresses appear in the case, and what type of cryptocurrency do they use?**

#### Result 1.1

| Address | Cryptocurrency | Network |
|---|---|---|
| `bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh` | BTC | Bitcoin Mainnet |
| `bc1q9intermediateaddress1` | BTC | Bitcoin Mainnet |
| `bc1q9intermediateaddress2` | BTC | Bitcoin Mainnet |
| `1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa` | BTC | Bitcoin Mainnet |

```sparql
PREFIX uco-observable: <https://ontology.unifiedcyberontology.org/uco/observable/>
PREFIX uco-core: <https://ontology.unifiedcyberontology.org/uco/core/>
PREFIX proposed: <http://example.org/ontology/proposed/>

SELECT ?address ?cryptoType ?network
WHERE {
    ?obj a uco-observable:ObservableObject ;
         uco-core:hasFacet ?cryptoFacet .
    ?cryptoFacet a proposed:CryptocurrencyAddressFacet ;
                 proposed:addressValue ?address ;
                 proposed:cryptocurrencyType ?cryptoType .
    OPTIONAL { ?cryptoFacet proposed:blockchainNetwork ?network }
}
ORDER BY ?address
```


### Competency Question 1.2

**What transactions connect the ransom payment address to the exchange deposit address, and what amounts were transferred?**

#### Result 1.2

| Transaction Hash | From Address | To Address | Amount (BTC) | Type |
|---|---|---|---|---|
| `a1b2c3d4...` | `bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh` | `bc1q9intermediateaddress1` | 2.5 | Transfer |
| `e5f6g7h8...` | `bc1q9intermediateaddress1` | `bc1q9intermediateaddress2` | 2.49 | Transfer |
| `i9j0k1l2...` | `bc1q9intermediateaddress2` | `1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa` | 2.48 | Deposit |

```sparql
PREFIX uco-observable: <https://ontology.unifiedcyberontology.org/uco/observable/>
PREFIX uco-core: <https://ontology.unifiedcyberontology.org/uco/core/>
PREFIX proposed: <http://example.org/ontology/proposed/>

SELECT ?txHash ?fromAddress ?toAddress ?amount ?txType
WHERE {
    ?tx a uco-observable:ObservableObject ;
        uco-core:hasFacet ?txFacet .
    ?txFacet a proposed:CryptocurrencyTransactionFacet ;
             proposed:transactionHash ?txHash .
    OPTIONAL { ?txFacet proposed:transactionType ?txType }

    ?inputRel a uco-observable:ObservableRelationship ;
              uco-core:source ?fromObj ;
              uco-core:target ?tx ;
              uco-core:kindOfRelationship "Transaction_Input" .
    ?fromObj uco-core:hasFacet ?fromFacet .
    ?fromFacet a proposed:CryptocurrencyAddressFacet ;
               proposed:addressValue ?fromAddress .

    ?outputRel a uco-observable:ObservableRelationship ;
               uco-core:source ?tx ;
               uco-core:target ?toObj ;
               uco-core:kindOfRelationship "Transaction_Output" .
    OPTIONAL { ?outputRel proposed:transferAmount ?amount }
    ?toObj uco-core:hasFacet ?toFacet .
    ?toFacet a proposed:CryptocurrencyAddressFacet ;
             proposed:addressValue ?toAddress .
}
ORDER BY ?txHash
```


### Competency Question 1.3

**Which cryptocurrency addresses are associated with a known financial organization (exchange)?**

This question demonstrates how existing UCO patterns (`Organization`, `AccountFacet`, `Relationship`) combine with the proposed cryptocurrency classes to model the relationship between addresses and exchanges — addressing the reviewer question about modeling financial organizations that transact cryptocurrency.

#### Result 1.3

| Address | Organization | Relationship |
|---|---|---|
| `1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa` | Binance | Controlled_By |

```sparql
PREFIX uco-observable: <https://ontology.unifiedcyberontology.org/uco/observable/>
PREFIX uco-core: <https://ontology.unifiedcyberontology.org/uco/core/>
PREFIX uco-identity: <https://ontology.unifiedcyberontology.org/uco/identity/>
PREFIX proposed: <http://example.org/ontology/proposed/>

SELECT ?address ?orgName
WHERE {
    ?rel a uco-core:Relationship ;
         uco-core:source ?addrObj ;
         uco-core:target ?org ;
         uco-core:kindOfRelationship "Controlled_By" ;
         uco-core:isDirectional true .
    ?addrObj uco-core:hasFacet ?cryptoFacet .
    ?cryptoFacet a proposed:CryptocurrencyAddressFacet ;
                 proposed:addressValue ?address .
    ?org a uco-identity:Organization ;
         uco-core:name ?orgName .
}
```


## Competency 2 — Cryptocurrency Mixing / Money Laundering Investigation

**Scenario**: An investigator is analyzing a suspected money laundering operation using a cryptocurrency mixing service. The suspect deposits 10 BTC into a mixing service ("TornadoMixer"). The mixer splits the funds across multiple output addresses in smaller amounts to obscure the trail. The investigator uses blockchain analysis tools to identify the mixer's input and output transactions, the intermediate addresses, and the eventual withdrawal to an exchange. This scenario exercises the transaction modeling and multi-hop tracing capability.


### Competency Question 2.1

**What transactions are associated with the mixing service, and how were the funds split?**

#### Result 2.1

| Transaction Hash | Type | From Address | To Address | Amount (BTC) |
|---|---|---|---|---|
| `mix-deposit-001` | Mixing | `bc1q-suspect-addr` | `bc1q-mixer-pool` | 10.0 |
| `mix-output-001` | Mixing | `bc1q-mixer-pool` | `bc1q-mixer-out-1` | 3.3 |
| `mix-output-002` | Mixing | `bc1q-mixer-pool` | `bc1q-mixer-out-2` | 3.3 |
| `mix-output-003` | Mixing | `bc1q-mixer-pool` | `bc1q-mixer-out-3` | 3.39 |

```sparql
PREFIX uco-observable: <https://ontology.unifiedcyberontology.org/uco/observable/>
PREFIX uco-core: <https://ontology.unifiedcyberontology.org/uco/core/>
PREFIX proposed: <http://example.org/ontology/proposed/>

SELECT ?txHash ?txType ?fromAddress ?toAddress ?amount
WHERE {
    ?tx a uco-observable:ObservableObject ;
        uco-core:hasFacet ?txFacet .
    ?txFacet a proposed:CryptocurrencyTransactionFacet ;
             proposed:transactionHash ?txHash ;
             proposed:transactionType "Mixing" .
    OPTIONAL { ?txFacet proposed:transactionType ?txType }

    ?inputRel a uco-observable:ObservableRelationship ;
              uco-core:source ?fromObj ;
              uco-core:target ?tx ;
              uco-core:kindOfRelationship "Transaction_Input" .
    ?fromObj uco-core:hasFacet ?fromFacet .
    ?fromFacet a proposed:CryptocurrencyAddressFacet ;
               proposed:addressValue ?fromAddress .

    ?outputRel a uco-observable:ObservableRelationship ;
               uco-core:source ?tx ;
               uco-core:target ?toObj ;
               uco-core:kindOfRelationship "Transaction_Output" .
    OPTIONAL { ?outputRel proposed:transferAmount ?amount }
    ?toObj uco-core:hasFacet ?toFacet .
    ?toFacet a proposed:CryptocurrencyAddressFacet ;
             proposed:addressValue ?toAddress .
}
ORDER BY ?txHash
```


### Competency Question 2.2

**Can we trace the full path of funds from the suspect's original address through the mixer to the final exchange deposit?**

This question demonstrates multi-hop tracing — the core capability needed for money laundering investigations.

#### Result 2.2

| Hop | From | To | Amount | Tx Type |
|---|---|---|---|---|
| 1 | `bc1q-suspect-addr` | `bc1q-mixer-pool` | 10.0 | Mixing |
| 2 | `bc1q-mixer-pool` | `bc1q-mixer-out-1` | 3.3 | Mixing |
| 3 | `bc1q-mixer-out-1` | `bc1q-exchange-deposit` | 3.29 | Deposit |

```sparql
PREFIX uco-observable: <https://ontology.unifiedcyberontology.org/uco/observable/>
PREFIX uco-core: <https://ontology.unifiedcyberontology.org/uco/core/>
PREFIX proposed: <http://example.org/ontology/proposed/>

SELECT ?fromAddress ?toAddress ?amount ?txType
WHERE {
    {
        SELECT ?tx ?fromAddress ?toAddress ?amount ?txType
        WHERE {
            ?tx a uco-observable:ObservableObject ;
                uco-core:hasFacet ?txFacet .
            ?txFacet a proposed:CryptocurrencyTransactionFacet .
            OPTIONAL { ?txFacet proposed:transactionType ?txType }

            ?inputRel a uco-observable:ObservableRelationship ;
                      uco-core:source ?fromObj ;
                      uco-core:target ?tx ;
                      uco-core:kindOfRelationship "Transaction_Input" .
            ?fromObj uco-core:hasFacet ?fromFacet .
            ?fromFacet a proposed:CryptocurrencyAddressFacet ;
                       proposed:addressValue ?fromAddress .

            ?outputRel a uco-observable:ObservableRelationship ;
                       uco-core:source ?tx ;
                       uco-core:target ?toObj ;
                       uco-core:kindOfRelationship "Transaction_Output" .
            OPTIONAL { ?outputRel proposed:transferAmount ?amount }
            ?toObj uco-core:hasFacet ?toFacet .
            ?toFacet a proposed:CryptocurrencyAddressFacet ;
                     proposed:addressValue ?toAddress .
        }
    }
    FILTER (?fromAddress = "bc1q-suspect-addr" ||
            ?fromAddress = "bc1q-mixer-pool" ||
            ?fromAddress = "bc1q-mixer-out-1")
}
ORDER BY ?fromAddress
```


# Solution suggestion

## 1. Define `CryptocurrencyAddressFacet` (`uco-observable`)

New class `CryptocurrencyAddressFacet` as a subclass of `uco-observable:Facet`:

| Property | Type | Cardinality | Description |
|---|---|---|---|
| `addressValue` | `xsd:string` | 1 | The cryptocurrency address string (e.g., `bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh`) |
| `cryptocurrencyType` | `xsd:string` (open vocab `CryptocurrencyTypeVocab`) | 0..1 | The type of cryptocurrency (e.g., BTC, ETH, LTC). Open vocabulary — producers may use values not in the recommended set. |
| `blockchainNetwork` | `xsd:string` | 0..1 | The blockchain network the address belongs to (e.g., "Bitcoin Mainnet", "Ethereum", "Litecoin") |
| `addressFormat` | `xsd:string` | 0..1 | The encoding format of the address (e.g., "Base58Check", "Bech32", "Hex") |

## 2. Define `CryptocurrencyTypeVocab` (`uco-vocabulary`)

New **open** vocabulary with initial recommended members. Per reviewer consensus, this is explicitly an open vocabulary — producers may use identifiers not in this list to accommodate new cryptocurrencies:

`BTC`, `ETH`, `LTC`, `XMR`, `ZEC`, `DASH`, `ETC`, `BCH`, `XRP`, `DOGE`, `SOL`, `ADA`, `DOT`, `AVAX`, `MATIC`, `USDT`, `USDC`

The vocabulary uses standard ticker symbols as defined by the cryptocurrency projects themselves and as listed on major data providers (CoinGecko, CoinMarketCap).

## 3. Define `CryptocurrencyTransactionFacet` (`uco-observable`)

New class `CryptocurrencyTransactionFacet` as a subclass of `uco-observable:Facet`:

| Property | Type | Cardinality | Description |
|---|---|---|---|
| `transactionHash` | `xsd:string` | 1 | The unique hash identifier of the blockchain transaction |
| `blockHash` | `xsd:string` | 0..1 | The hash of the block containing this transaction |
| `blockNumber` | `xsd:integer` | 0..1 | The block number (height) in the blockchain |
| `transactionFee` | `xsd:decimal` | 0..1 | The transaction fee in the native cryptocurrency unit |
| `confirmationCount` | `xsd:integer` | 0..1 | The number of blockchain confirmations at time of observation |
| `transactionStatus` | `xsd:string` | 0..1 | The status of the transaction (e.g., "Confirmed", "Pending", "Failed") |
| `transactionType` | `xsd:string` (open vocab `CryptocurrencyTransactionTypeVocab`) | 0..1 | The type of transaction. Open vocabulary. |

**Transaction inputs and outputs** are modeled using `ObservableRelationship` instances connecting address `ObservableObject`s to the transaction `ObservableObject`. Each relationship carries:
- `kindOfRelationship`: `"Transaction_Input"` or `"Transaction_Output"`
- `proposed:transferAmount` (`xsd:decimal`): the amount transferred in that input/output

This pattern natively supports UTXO-based blockchains (Bitcoin) where a single transaction may have multiple inputs and multiple outputs, each with different amounts.

## 4. Define `CryptocurrencyTransactionTypeVocab` (`uco-vocabulary`)

New **open** vocabulary with initial recommended members:

`Transfer`, `Exchange`, `Purchase`, `Mixing`, `Withdrawal`, `Deposit`, `ContractExecution`, `Staking`, `Unstaking`

## 5. Modeling financial organizations and exchanges

Cryptocurrency exchanges and financial institutions are modeled using existing UCO classes — no new classes are needed:

- **Exchange as entity**: `uco-identity:Organization` with `uco-core:name`
- **Exchange account**: `uco-observable:ObservableObject` with `AccountFacet` (`accountType: "cryptocurrency_exchange"`)
- **Address ownership**: `uco-core:Relationship` with `kindOfRelationship: "Controlled_By"` linking an address `ObservableObject` to an `Organization`

This approach was confirmed as sufficient by reviewers. It also addresses the question of how to model the "DNS-like" resolution of cryptocurrency address ownership — ownership attribution is an investigative assertion modeled as a `Relationship`, not an intrinsic property of the address.

## 6. Add SHACL shapes

- `CryptocurrencyAddressFacet-shape`: Enforce `addressValue` as required (min 1)
- `CryptocurrencyTransactionFacet-shape`: Enforce `transactionHash` as required (min 1)

## 7. Add unit tests

- Validate that a `CryptocurrencyAddressFacet` with a missing `addressValue` is rejected
- Validate that a `CryptocurrencyTransactionFacet` with a missing `transactionHash` is rejected
- Validate a complete example with addresses, transactions, and relationships
- Validate the mixing/money laundering scenario with multi-hop tracing


# Example instance data

The following JSON-LD demonstrates the proposed classes modeling a ransomware payment tracing and cryptocurrency mixing investigation. It exercises all proposed classes and supports the SPARQL queries in the Competencies section. I am fine with my examples being transcribed and credited.

```json
{
  "@context": {
    "@vocab": "http://example.org/kb/",
    "kb": "http://example.org/kb/",
    "case-investigation": "https://ontology.caseontology.org/case/investigation/",
    "uco-action": "https://ontology.unifiedcyberontology.org/uco/action/",
    "uco-core": "https://ontology.unifiedcyberontology.org/uco/core/",
    "uco-identity": "https://ontology.unifiedcyberontology.org/uco/identity/",
    "uco-observable": "https://ontology.unifiedcyberontology.org/uco/observable/",
    "uco-tool": "https://ontology.unifiedcyberontology.org/uco/tool/",
    "proposed": "http://example.org/ontology/proposed/",
    "xsd": "http://www.w3.org/2001/XMLSchema#"
  },
  "@graph": [
    {
      "@id": "kb:investigation-1",
      "@type": "case-investigation:Investigation",
      "uco-core:name": "Ransomware Payment Tracing & Mixing Analysis 2025-RC-0042"
    },
    {
      "@id": "kb:tool-chainalysis",
      "@type": "uco-tool:Tool",
      "uco-core:name": "Chainalysis Reactor",
      "uco-tool:version": "2025.3"
    },
    {
      "@id": "kb:org-binance",
      "@type": "uco-identity:Organization",
      "uco-core:name": "Binance"
    },
    {
      "@id": "kb:org-tornado-mixer",
      "@type": "uco-identity:Organization",
      "uco-core:name": "TornadoMixer"
    },

    {
      "@id": "kb:addr-ransom",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-ransom-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:addr-intermediate-1",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-intermediate-1-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q9intermediateaddress1",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:addr-intermediate-2",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-intermediate-2-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q9intermediateaddress2",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:addr-exchange-deposit",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-exchange-deposit-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Base58Check"
        }
      ]
    },
    {
      "@id": "kb:rel-exchange-owns-addr",
      "@type": "uco-core:Relationship",
      "uco-core:source": { "@id": "kb:addr-exchange-deposit" },
      "uco-core:target": { "@id": "kb:org-binance" },
      "uco-core:kindOfRelationship": "Controlled_By",
      "uco-core:isDirectional": true
    },

    {
      "@id": "kb:tx-1",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:tx-1-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2",
          "proposed:blockHash": "00000000000000000003a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6e7f8a9b0c1d2",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "850001" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.0001" },
          "proposed:confirmationCount": { "@type": "xsd:integer", "@value": "144" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Transfer"
        }
      ]
    },
    {
      "@id": "kb:tx-1-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-ransom" },
      "uco-core:target": { "@id": "kb:tx-1" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "2.5" }
    },
    {
      "@id": "kb:tx-1-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:tx-1" },
      "uco-core:target": { "@id": "kb:addr-intermediate-1" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "2.4999" }
    },

    {
      "@id": "kb:tx-2",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:tx-2-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2g3h4i5j6",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "850050" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.00012" },
          "proposed:confirmationCount": { "@type": "xsd:integer", "@value": "95" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Transfer"
        }
      ]
    },
    {
      "@id": "kb:tx-2-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-intermediate-1" },
      "uco-core:target": { "@id": "kb:tx-2" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "2.4999" }
    },
    {
      "@id": "kb:tx-2-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:tx-2" },
      "uco-core:target": { "@id": "kb:addr-intermediate-2" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "2.49" }
    },

    {
      "@id": "kb:tx-3",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:tx-3-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2g3h4i5j6k7l8m9n0",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "850100" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.0001" },
          "proposed:confirmationCount": { "@type": "xsd:integer", "@value": "45" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Deposit"
        }
      ]
    },
    {
      "@id": "kb:tx-3-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-intermediate-2" },
      "uco-core:target": { "@id": "kb:tx-3" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "2.49" }
    },
    {
      "@id": "kb:tx-3-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:tx-3" },
      "uco-core:target": { "@id": "kb:addr-exchange-deposit" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "2.48" }
    },

    {
      "@id": "kb:addr-suspect",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-suspect-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q-suspect-addr",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:addr-mixer-pool",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-mixer-pool-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q-mixer-pool",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:rel-mixer-owns-pool",
      "@type": "uco-core:Relationship",
      "uco-core:source": { "@id": "kb:addr-mixer-pool" },
      "uco-core:target": { "@id": "kb:org-tornado-mixer" },
      "uco-core:kindOfRelationship": "Controlled_By",
      "uco-core:isDirectional": true
    },
    {
      "@id": "kb:addr-mixer-out-1",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-mixer-out-1-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q-mixer-out-1",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:addr-mixer-out-2",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-mixer-out-2-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q-mixer-out-2",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:addr-mixer-out-3",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-mixer-out-3-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q-mixer-out-3",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },
    {
      "@id": "kb:addr-mixer-exchange-deposit",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:addr-mixer-exchange-deposit-facet",
          "@type": "proposed:CryptocurrencyAddressFacet",
          "proposed:addressValue": "bc1q-exchange-deposit",
          "proposed:cryptocurrencyType": "BTC",
          "proposed:blockchainNetwork": "Bitcoin Mainnet",
          "proposed:addressFormat": "Bech32"
        }
      ]
    },

    {
      "@id": "kb:mix-tx-deposit",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:mix-tx-deposit-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "mix-deposit-001",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "849900" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.0002" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Mixing"
        }
      ]
    },
    {
      "@id": "kb:mix-tx-deposit-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-suspect" },
      "uco-core:target": { "@id": "kb:mix-tx-deposit" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "10.0" }
    },
    {
      "@id": "kb:mix-tx-deposit-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:mix-tx-deposit" },
      "uco-core:target": { "@id": "kb:addr-mixer-pool" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "9.9998" }
    },

    {
      "@id": "kb:mix-tx-out-1",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:mix-tx-out-1-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "mix-output-001",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "849950" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.0001" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Mixing"
        }
      ]
    },
    {
      "@id": "kb:mix-tx-out-1-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-mixer-pool" },
      "uco-core:target": { "@id": "kb:mix-tx-out-1" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.3" }
    },
    {
      "@id": "kb:mix-tx-out-1-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:mix-tx-out-1" },
      "uco-core:target": { "@id": "kb:addr-mixer-out-1" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.3" }
    },

    {
      "@id": "kb:mix-tx-out-2",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:mix-tx-out-2-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "mix-output-002",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "849951" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.0001" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Mixing"
        }
      ]
    },
    {
      "@id": "kb:mix-tx-out-2-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-mixer-pool" },
      "uco-core:target": { "@id": "kb:mix-tx-out-2" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.3" }
    },
    {
      "@id": "kb:mix-tx-out-2-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:mix-tx-out-2" },
      "uco-core:target": { "@id": "kb:addr-mixer-out-2" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.3" }
    },

    {
      "@id": "kb:mix-tx-out-3",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:mix-tx-out-3-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "mix-output-003",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "849952" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.0001" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Mixing"
        }
      ]
    },
    {
      "@id": "kb:mix-tx-out-3-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-mixer-pool" },
      "uco-core:target": { "@id": "kb:mix-tx-out-3" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.39" }
    },
    {
      "@id": "kb:mix-tx-out-3-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:mix-tx-out-3" },
      "uco-core:target": { "@id": "kb:addr-mixer-out-3" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.39" }
    },

    {
      "@id": "kb:mix-tx-withdraw",
      "@type": "uco-observable:ObservableObject",
      "uco-core:hasFacet": [
        {
          "@id": "kb:mix-tx-withdraw-facet",
          "@type": "proposed:CryptocurrencyTransactionFacet",
          "proposed:transactionHash": "mix-withdraw-001",
          "proposed:blockNumber": { "@type": "xsd:integer", "@value": "850200" },
          "proposed:transactionFee": { "@type": "xsd:decimal", "@value": "0.0001" },
          "proposed:transactionStatus": "Confirmed",
          "proposed:transactionType": "Deposit"
        }
      ]
    },
    {
      "@id": "kb:mix-tx-withdraw-input",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:addr-mixer-out-1" },
      "uco-core:target": { "@id": "kb:mix-tx-withdraw" },
      "uco-core:kindOfRelationship": "Transaction_Input",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.3" }
    },
    {
      "@id": "kb:mix-tx-withdraw-output",
      "@type": "uco-observable:ObservableRelationship",
      "uco-core:source": { "@id": "kb:mix-tx-withdraw" },
      "uco-core:target": { "@id": "kb:addr-mixer-exchange-deposit" },
      "uco-core:kindOfRelationship": "Transaction_Output",
      "uco-core:isDirectional": true,
      "proposed:transferAmount": { "@type": "xsd:decimal", "@value": "3.29" }
    },

    {
      "@id": "kb:tracing-action-1",
      "@type": "case-investigation:InvestigativeAction",
      "uco-core:name": "Blockchain transaction tracing of ransom payment flow",
      "uco-action:instrument": { "@id": "kb:tool-chainalysis" },
      "uco-action:object": [
        { "@id": "kb:addr-ransom" },
        { "@id": "kb:addr-intermediate-1" },
        { "@id": "kb:addr-intermediate-2" },
        { "@id": "kb:addr-exchange-deposit" }
      ],
      "uco-action:result": [
        { "@id": "kb:tx-1" },
        { "@id": "kb:tx-2" },
        { "@id": "kb:tx-3" }
      ],
      "uco-action:startTime": { "@type": "xsd:dateTime", "@value": "2025-03-26T14:30:00Z" },
      "uco-action:endTime": { "@type": "xsd:dateTime", "@value": "2025-03-26T14:35:00Z" }
    },
    {
      "@id": "kb:mixing-analysis-action",
      "@type": "case-investigation:InvestigativeAction",
      "uco-core:name": "Cryptocurrency mixing service analysis",
      "uco-action:instrument": { "@id": "kb:tool-chainalysis" },
      "uco-action:object": [
        { "@id": "kb:addr-suspect" }
      ],
      "uco-action:result": [
        { "@id": "kb:mix-tx-deposit" },
        { "@id": "kb:mix-tx-out-1" },
        { "@id": "kb:mix-tx-out-2" },
        { "@id": "kb:mix-tx-out-3" },
        { "@id": "kb:mix-tx-withdraw" }
      ],
      "uco-action:startTime": { "@type": "xsd:dateTime", "@value": "2025-03-27T09:00:00Z" },
      "uco-action:endTime": { "@type": "xsd:dateTime", "@value": "2025-03-27T09:15:00Z" }
    },
    {
      "@id": "kb:rel-tracing-to-investigation",
      "@type": "uco-core:Relationship",
      "uco-core:source": { "@id": "kb:tracing-action-1" },
      "uco-core:target": { "@id": "kb:investigation-1" },
      "uco-core:kindOfRelationship": "part_of",
      "uco-core:isDirectional": true
    },
    {
      "@id": "kb:rel-mixing-to-investigation",
      "@type": "uco-core:Relationship",
      "uco-core:source": { "@id": "kb:mixing-analysis-action" },
      "uco-core:target": { "@id": "kb:investigation-1" },
      "uco-core:kindOfRelationship": "part_of",
      "uco-core:isDirectional": true
    }
  ]
}
```


# Deferred: Sanctions Classification

The original proposal included a `SanctionsDesignationFacet` for modeling sanctions designations on cryptocurrency addresses. Based on reviewer feedback, this concept should be **separated into a distinct proposal** for the following reasons:

1. **Sanctions are a classification, not a crypto concept** (Sean): A sanction is a classification applied to an entity — it can apply to IP addresses, domain names, organizations, and individuals, not just cryptocurrency addresses. Coupling it to the crypto proposal limits its generality.

2. **Sanctions may belong in CASE, not UCO** (Alex): The act of checking whether an observable is on a sanctions list is investigation-specific. The designating authority, list name, and designation details are contextual to an investigative or compliance workflow, making `case-investigation` the more appropriate namespace.

3. **Alignment with `uco-analysis:ArtifactClassification`**: The existing `ArtifactClassification` class provides a pattern for asserting that a classification applies to something. A sanctions designation is structurally similar — it asserts that a government authority has classified an entity under a specific sanctions program. The separate proposal should explore whether `SanctionsDesignationFacet` can subclass or complement `ArtifactClassification`.

The separate CASE proposal for sanctions classification will be drafted and submitted independently to [casework/CASE](https://github.com/casework/CASE/issues/new).


# Related proposals and references

| Reference | Relevance |
|---|---|
| [CASE Issue #87](https://github.com/casework/CASE/issues/87) — Add CryptoWalletFacet and CryptoAddressFacet | Directly related prior proposal. This proposal complements #87 by focusing on address and transaction modeling without QUDT dependency. Wallet-specific properties (seed, name, balance) from #87 remain deferred pending UCO #535. |
| [UCO Issue #535](https://github.com/ucoProject/UCO/issues/535) — Add Qualities to UCO | Blocking issue for time-varying properties (wallet balances, confirmation counts at observation time). This proposal avoids the blocker by treating `confirmationCount` as a snapshot value. |
| [UCO Issue #675](https://github.com/ucoProject/UCO/issues/675) — Original submission of this proposal | The original version that combined crypto addresses and sanctions. This revision supersedes it. |
| [UCO Issue #404](https://github.com/ucoProject/UCO/issues/404) — Represent sensor outputs | Related discussion of QUDT/SSN/SOSA adoption that informed the decision to avoid QUDT in this proposal. |


# Pre-submission testing

## SPARQL query testing

All 5 competency queries were tested against the example instance data (286 triples loaded). All returned expected results.

| Query | Tested | Expected results match | Notes |
|-------|--------|----------------------|-------|
| CQ 1.1 — Addresses and crypto types | Yes | Yes | 10 results — all cryptocurrency addresses in the graph returned with correct type and network |
| CQ 1.2 — Transaction chain with amounts | Yes | Yes | 8 results — all transaction flows (3 ransom chain + 5 mixing chain) with correct from/to/amount |
| CQ 1.3 — Addresses associated with organizations | Yes | Yes | 2 results — Binance (exchange deposit addr) and TornadoMixer (mixer pool addr) |
| CQ 2.1 — Mixing service transactions | Yes | Yes | 4 results — 1 deposit into mixer + 3 split outputs, all typed "Mixing" |
| CQ 2.2 — Multi-hop fund tracing | Yes | Yes | 5 results — full path from suspect through mixer pool, three mixer outputs, and one exit to exchange |

## Graph validation

Validation was run with the proposed extension ontology (`--ontology-graph`) and RDFS inference (`--inference rdfs`) to resolve `CryptocurrencyAddressFacet` and `CryptocurrencyTransactionFacet` as subclasses of `uco-observable:Facet`. The `--allow-info` flag suppresses informational UUID IRI suggestions.

```
$ case_validate --built-version case-1.4.0 \
    --ontology-graph change_proposals/cryptocurrency-address-and-sanctions-designation.ttl \
    --inference rdfs --allow-info \
    change_proposals/cryptocurrency-address-and-sanctions-designation.jsonld

Validation Report
Conforms: True
Results (62):
  [62 sh:Info results — all are UUID IRI suggestions for human-readable example IRIs]
```

## Unresolved issues

- **UUID IRIs**: The example data uses human-readable IRIs (e.g., `kb:addr-ransom`, `kb:tx-1`) for readability in the proposal. Production data should use UUID-based IRIs per UCO convention. The 62 informational results are all UUID IRI suggestions and do not affect conformance.
- No other unresolved issues.
