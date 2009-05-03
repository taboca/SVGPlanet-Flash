y())
		{
			pFX->m_prs->SetDirtyFieldStatus(nField - 1);
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		}
		return;

	case CFieldExchange::MarkForUpdate:
		if (value.IsEmpty())
			pFX->m_prs->SetNullFieldStatus(nField - 1);
		else
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		pFX->Default(szName, &value, plLength,
			nFieldType, value.GetLength() * sizeof(StringType::XCHAR), nMaxLength);
		return;

	case CFieldExchange::LoadField:
		{
			// Get the field data
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];

			// Restore the status
			pFX->m_prs->SetFieldStatus(nField - 1, pInfo->m_bStatus);

			// If not NULL, restore the value and length
			if (!pFX->m_prs->IsFieldStatusNull(nField - 1))
			{
				value = *static_cast<StringType *>(pInfo->m_pvDataCache);
				*plLength = value.GetLength() * sizeof(StringType::XCHAR);
			}
			else
				*plLength = SQL_NULL_DATA;

#ifdef _DEBUG
			// Buffer address must not change - ODBC's SQLBindCol depends upon this
			void* pvBind = value.GetBuffer(0);
			value.ReleaseBuffer();
			if (pvBind != pInfo->m_pvBindAddress)
			{
				TRACE(traceDatabase, 0, "Error: CString buffer (column %u) address has changed!\n",
					nField);
				ASSERT(FALSE);
			}
#endif // _DEBUG
		}
		return;

	case CFieldExchange::StoreField:
		AfxStoreField(*pFX->m_prs, nField, &value);
		return;

	case CFieldExchange::AllocCache:
		{
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];
			pInfo->m_pvDataCache = new StringType;
			pInfo->m_nDataType = nFieldType == SQL_C_WCHAR ? AFX_RFX_WTEXT : AFX_RFX_ATEXT;
		}
		return;

#ifdef _DEBUG
	case CFieldExchange::DumpField:
		*pFX->m_pdcDump << "\n" << szName << " = " << value;
		return;
#endif // _DEBUG

	}
}
} // namespace

void AFXAPI RFX_Text(CFieldExchange* pFX, LPCTSTR szName,
	__out_ecount(nMaxLength) LPWSTR value, int nMaxLength, int nColumnType, short nScale)
{
	nsRFX_Text::RFX_Text(pFX, szName, value, nMaxLength, nColumnType, nScale, SQL_C_WCHAR, L' ');
}

void AFXAPI RFX_Text(CFieldExchange* pFX, LPCTSTR szName,
	__out_ecount(nMaxLength) LPSTR value, int nMaxLength, int nColumnType, short nScale)
{
	nsRFX_Text::RFX_Text(pFX, szName, value, nMaxLength, nColumnType, nScale, SQL_C_CHAR, ' ');
}

void AFXAPI RFX_Text(CFieldExchange* pFX, LPCTSTR szName,
	CStringW &value, int nMaxLength, int nColumnType, short nScale)
{
	nsRFX_Text::RFX_Text(pFX, szName, value, nMaxLength, nColumnType, nScale, SQL_C_WCHAR, L' ');
}

void AFXAPI RFX_Text(CFieldExchange* pFX, LPCTSTR szName,
	CStringA &value, int nMaxLength, int nColumnType, short nScale)
{
	nsRFX_Text::RFX_Text(pFX, szName, value, nMaxLength, nColumnType, nScale, SQL_C_CHAR, ' ');
}

void AFXAPI RFX_Int(CFieldExchange* pFX, LPCTSTR szName, int& value)
{
	ENSURE_ARG(AfxIsValidAddress(pFX, sizeof(CFieldExchange)));
	ENSURE_ARG(AfxIsValidString(szName));

	UINT nField;
	if (!pFX->IsFieldType(&nField))
		return;

	LONG_PTR* plLength = pFX->m_prs->GetFieldLengthBuffer(
		nField - 1, pFX->m_nFieldType);
	switch (pFX->m_nOperation)
	{
	case CFieldExchange::BindFieldToColumn:
		{
#ifdef _DEBUG
			// Assumes all bound fields BEFORE unbound fields
			CODBCFieldInfo* pODBCInfo =
				&pFX->m_prs->m_rgODBCFieldInfos[nField - 1];

			if (pODBCInfo->m_nSQLType != SQL_C_SHORT)
			{
				// Warn of possible field schema mismatch
				TRACE(traceDatabase, 1, "Warning: int converted from SQL type %ld.\n",
					pODBCInfo->m_nSQLType);
			}
#endif // _DEBUG
		}
		// fall through

	default:
LDefault:
		pFX->Default(szName, &value, plLength, SQL_C_LONG,
			sizeof(value), 5);
		return;

	case CFieldExchange::Fixup:
		if (*plLength == SQL_NULL_DATA)
		{
			pFX->m_prs->SetNullFieldStatus(nField - 1);
			value = AFX_RFX_INT_PSEUDO_NULL;
		}
		return;

	case CFieldExchange::SetFieldNull:
		if ((pFX->m_pvField == NULL &&
			pFX->m_nFieldType == CFieldExchange::outputColumn) ||
			pFX->m_pvField == &value)
		{
			if (pFX->m_bField)
			{
				// Mark fields null
				pFX->m_prs->SetNullFieldStatus(nField - 1);
				value = AFX_RFX_INT_PSEUDO_NULL;
				*plLength = SQL_NULL_DATA;
			}
			else
			{
				pFX->m_prs->ClearNullFieldStatus(nField - 1);
				*plLength = sizeof(value);
			}
#ifdef _DEBUG
			pFX->m_nFieldFound = nField;
#endif
		}
		return;

	case CFieldExchange::MarkForAddNew:
		// can force writing of psuedo-null value (as a non-null) by setting field dirty
		if (value != AFX_RFX_INT_PSEUDO_NULL)
		{
			pFX->m_prs->SetDirtyFieldStatus(nField - 1);
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		}
		return;

	case CFieldExchange::MarkForUpdate:
		if (value != AFX_RFX_INT_PSEUDO_NULL)
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		goto LDefault;

	case CFieldExchange::AllocCache:
		{
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];

			// Data cached by value, no allocation necessary
			pInfo->m_nDataType = AFX_RFX_INT;
		}
		return;

#ifdef _DEBUG
	case CFieldExchange::DumpField:
		*pFX->m_pdcDump << "\n" << szName << " = " << value;
		return;
#endif // _DEBUG

	}
}

void AFXAPI RFX_BigInt(CFieldExchange* pFX, LPCTSTR szName, LONGLONG& value)
{
	ENSURE_ARG(AfxIsValidAddress(pFX, sizeof(CFieldExchange)));
	ENSURE_ARG(AfxIsValidString(szName));

	UINT nField;
	if (!pFX->IsFieldType(&nField))
		return;

	LONG_PTR* plLength = pFX->m_prs->GetFieldLengthBuffer(
		nField - 1, pFX->m_nFieldType);
	switch (pFX->m_nOperation)
	{
	case CFieldExchange::BindFieldToColumn:
		{
#ifdef _DEBUG
			// Assumes all bound fields BEFORE unbound fields
			CODBCFieldInfo* pODBCInfo =
				&pFX->m_prs->m_rgODBCFieldInfos[nField - 1];

			if (pODBCInfo->m_nSQLType != SQL_C_SBIGINT)
			{
				// Warn of possible field schema mismatch
				TRACE(traceDatabase, 1, "Warning: long converted from SQL type %ld.\n",
					pODBCInfo->m_nSQLType);
			}
#endif // _DEBUG
		}
		// fall through

	default:
LDefault:
		pFX->Default(szName, &value, plLength, SQL_C_SBIGINT,
			sizeof(value), 19);
		return;

	case CFieldExchange::Fixup:
		if (*plLength == SQL_NULL_DATA)
		{
			pFX->m_prs->SetNullFieldStatus(nField - 1);
			value = AFX_RFX_BIGINT_PSEUDO_NULL;
		}
		return;

	case CFieldExchange::SetFieldNull:
		if ((pFX->m_pvField == NULL &&
			pFX->m_nFieldType == CFieldExchange::outputColumn) ||
			pFX->m_pvField == &value)
		{
			if (pFX->m_bField)
			{
				// Mark fields null
				pFX->m_prs->SetNullFieldStatus(nField - 1);
				value = AFX_RFX_BIGINT_PSEUDO_NULL;
				*plLength = SQL_NULL_DATA;
			}
			else
			{
				pFX->m_prs->ClearNullFieldStatus(nField - 1);
				*plLength = sizeof(value);
			}
#ifdef _DEBUG
			pFX->m_nFieldFound = nField;
#endif
		}
		return;

	case CFieldExchange::MarkForAddNew:
		// can force writing of psuedo-null value (as a non-null) by setting field dirty
		if (value != AFX_RFX_BIGINT_PSEUDO_NULL)
		{
			pFX->m_prs->SetDirtyFieldStatus(nField - 1);
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		}
		return;

	case CFieldExchange::MarkForUpdate:
		if (value != AFX_RFX_LONG_PSEUDO_NULL)
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		goto LDefault;

	case CFieldExchange::AllocCache:
		{
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];
			pInfo->m_pvDataCache = new LONGLONG;
			pInfo->m_nDataType = AFX_RFX_BIGINT;
		}
		return;

#ifdef _DEBUG
	case CFieldExchange::DumpField:
		*pFX->m_pdcDump << "\n" << szName << " = " << value;
		return;
#endif // _DEBUG

	}
}

void AFXAPI RFX_Long(CFieldExchange* pFX, LPCTSTR szName, long& value)
{
	ENSURE_ARG(AfxIsValidAddress(pFX, sizeof(CFieldExchange)));
	ENSURE_ARG(AfxIsValidString(szName));

	UINT nField;
	if (!pFX->IsFieldType(&nField))
		return;

	LONG_PTR* plLength = pFX->m_prs->GetFieldLengthBuffer(
		nField - 1, pFX->m_nFieldType);
	switch (pFX->m_nOperation)
	{
	case CFieldExchange::BindFieldToColumn:
		{
#ifdef _DEBUG
			// Assumes all bound fields BEFORE unbound fields
			CODBCFieldInfo* pODBCInfo =
				&pFX->m_prs->m_rgODBCFieldInfos[nField - 1];

			if (pODBCInfo->m_nSQLType != SQL_C_LONG)
			{
				// Warn of possible field schema mismatch
				TRACE(traceDatabase, 1, "Warning: long converted from SQL type %ld.\n",
					pODBCInfo->m_nSQLType);
			}
#endif // _DEBUG
		}
		// fall through

	default:
LDefault:
		pFX->Default(szName, &value, plLength, SQL_C_LONG,
			sizeof(value), 10);
		return;

	case CFieldExchange::Fixup:
		if (*plLength == SQL_NULL_DATA)
		{
			pFX->m_prs->SetNullFieldStatus(nField - 1);
			value = AFX_RFX_LONG_PSEUDO_NULL;
		}
		return;

	case CFieldExchange::SetFieldNull:
		if ((pFX->m_pvField == NULL &&
			pFX->m_nFieldType == CFieldExchange::outputColumn) ||
			pFX->m_pvField == &value)
		{
			if (pFX->m_bField)
			{
				// Mark fields null
				pFX->m_prs->SetNullFieldStatus(nField - 1);
				value = AFX_RFX_LONG_PSEUDO_NULL;
				*plLength = SQL_NULL_DATA;
			}
			else
			{
				pFX->m_prs->ClearNullFieldStatus(nField - 1);
				*plLength = sizeof(value);
			}
#ifdef _DEBUG
			pFX->m_nFieldFound = nField;
#endif
		}
		return;

	case CFieldExchange::MarkForAddNew:
		// can force writing of psuedo-null value (as a non-null) by setting field dirty
		if (value != AFX_RFX_LONG_PSEUDO_NULL)
		{
			pFX->m_prs->SetDirtyFieldStatus(nField - 1);
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		}
		return;

	case CFieldExchange::MarkForUpdate:
		if (value != AFX_RFX_LONG_PSEUDO_NULL)
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		goto LDefault;

	case CFieldExchange::AllocCache:
		{
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];

			// Data cached by value, no allocation necessary
			pInfo->m_nDataType = AFX_RFX_LONG;
		}
		return;

#ifdef _DEBUG
	case CFieldExchange::DumpField:
		*pFX->m_pdcDump << "\n" << szName << " = " << value;
		return;
#endif // _DEBUG

	}
}

void AFXAPI RFX_Byte(CFieldExchange* pFX, LPCTSTR szName, BYTE& value)
{
	ENSURE_ARG(AfxIsValidAddress(pFX, sizeof(CFieldExchange)));
	ENSURE_ARG(AfxIsValidString(szName));

	UINT nField;
	if (!pFX->IsFieldType(&nField))
		return;

	LONG_PTR* plLength = pFX->m_prs->GetFieldLengthBuffer(
		nField - 1, pFX->m_nFieldType);
	switch (pFX->m_nOperation)
	{
	case CFieldExchange::BindFieldToColumn:
		{
#ifdef _DEBUG
			// Assumes all bound fields BEFORE unbound fields
			CODBCFieldInfo* pODBCInfo =
				&pFX->m_prs->m_rgODBCFieldInfos[nField - 1];

			if (pODBCInfo->m_nSQLType != SQL_TINYINT)
			{
				// Warn of possible field schema mismatch
				TRACE(traceDatabase, 1, "Warning: BYTE converted from SQL type %ld.\n",
					pODBCInfo->m_nSQLType);
			}
#endif // _DEBUG
		}
		// fall through

	default:
LDefault:
		pFX->Default(szName, &value, plLength, SQL_TINYINT,
			sizeof(value), 3);
		break;

	case CFieldExchange::Fixup:
		if (*plLength == SQL_NULL_DATA)
		{
			pFX->m_prs->SetNullFieldStatus(nField - 1);
			value = AFX_RFX_BYTE_PSEUDO_NULL;
		}
		return;

	case CFieldExchange::SetFieldNull:
		if ((pFX->m_pvField == NULL &&
			pFX->m_nFieldType == CFieldExchange::outputColumn) ||
			pFX->m_pvField == &value)
		{
			if (pFX->m_bField)
			{
				// Mark fields null
				pFX->m_prs->SetNullFieldStatus(nField - 1);
				value = AFX_RFX_BYTE_PSEUDO_NULL;
				*plLength = SQL_NULL_DATA;
			}
			else
			{
				pFX->m_prs->ClearNullFieldStatus(nField - 1);
				*plLength = sizeof(value);
			}
#ifdef _DEBUG
			pFX->m_nFieldFound = nField;
#endif
		}
		return;

	case CFieldExchange::MarkForAddNew:
		// can force writing of psuedo-null value (as a non-null) by setting field dirty
		if (value != AFX_RFX_BYTE_PSEUDO_NULL)
		{
			pFX->m_prs->SetDirtyFieldStatus(nField - 1);
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		}
		return;

	case CFieldExchange::MarkForUpdate:
		if (value != AFX_RFX_BYTE_PSEUDO_NULL)
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		goto LDefault;

	case CFieldExchange::AllocCache:
		{
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];

			// Data cached by value, no allocation necessary
			pInfo->m_nDataType = AFX_RFX_BYTE;
		}
		return;

#ifdef _DEBUG
	case CFieldExchange::DumpField:
		*pFX->m_pdcDump << "\n" << szName << " = " << value;
		return;
#endif // _DEBUG

	}
}

void AFXAPI RFX_Bool(CFieldExchange* pFX, LPCTSTR szName, BOOL& value)
{
	ENSURE_ARG(AfxIsValidAddress(pFX, sizeof(CFieldExchange)));
	ENSURE_ARG(AfxIsValidString(szName));

	UINT nField;
	if (!pFX->IsFieldType(&nField))
		return;

	LONG_PTR* plLength = pFX->m_prs->GetFieldLengthBuffer(
		nField - 1, pFX->m_nFieldType);
	switch (pFX->m_nOperation)
	{
	case CFieldExchange::BindFieldToColumn:
		{
#ifdef _DEBUG
			// Assumes all bound fields BEFORE unbound fields
			CODBCFieldInfo* pODBCInfo =
				&pFX->m_prs->m_rgODBCFieldInfos[nField - 1];

			if (pODBCInfo->m_nSQLType != SQL_BIT)
			{
				// Warn of possible field schema mismatch
				TRACE(traceDatabase, 1, "Warning: BOOL converted from SQL type %ld.\n",
					pODBCInfo->m_nSQLType);
			}
#endif // _DEBUG
		}
		// Fall through

	default:
LDefault:
		pFX->Default(szName, &value, plLength, SQL_BIT,
			sizeof(value), 1);
		return;

	case CFieldExchange::Fixup:
		if (*plLength == SQL_NULL_DATA)
		{
			pFX->m_prs->SetNullFieldStatus(nField - 1);
			value = AFX_RFX_BOOL_PSEUDO_NULL;
		}
		else
			// Cast BYTE into BOOL (int)
			value = *(BYTE *)&value;
		return;

	case CFieldExchange::SetFieldNull:
		if ((pFX->m_pvField == NULL &&
			pFX->m_nFieldType == CFieldExchange::outputColumn) ||
			pFX->m_pvField == &value)
		{
			if (pFX->m_bField)
			{
				// Mark fields null
				pFX->m_prs->SetNullFieldStatus(nField - 1);
				value = AFX_RFX_BOOL_PSEUDO_NULL;
				*plLength = SQL_NULL_DATA;
			}
			else
			{
				pFX->m_prs->ClearNullFieldStatus(nField - 1);
				*plLength = sizeof(value);
			}
#ifdef _DEBUG
			pFX->m_nFieldFound = nField;
#endif
		}
		return;

	case CFieldExchange::MarkForAddNew:
		// can force writing of psuedo-null value (as a non-null) by setting field dirty
		if (value != AFX_RFX_BOOL_PSEUDO_NULL)
		{
			pFX->m_prs->SetDirtyFieldStatus(nField - 1);
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		}
		return;

	case CFieldExchange::MarkForUpdate:
		if (value != AFX_RFX_BOOL_PSEUDO_NULL)
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		goto LDefault;

	case CFieldExchange::AllocCache:
		{
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];

			// Data cached by value, no allocation necessary
			pInfo->m_nDataType = AFX_RFX_BOOL;
		}
		return;

#ifdef _DEBUG
	case CFieldExchange::DumpField:
		*pFX->m_pdcDump << "\n" << szName << " = " << value;
		return;
#endif // _DEBUG

	}
}

// Note: CByteArray.m_pData must not be changed.  This address is registered
// with ODBC and must remain valid until the recordset is released.
void AFXAPI RFX_Binary(CFieldExchange* pFX, LPCTSTR szName,
	CByteArray& value, INT_PTR nMaxLength)
{
	ENSURE_ARG(AfxIsValidAddress(pFX, sizeof(CFieldExchange)));
	ENSURE_ARG(AfxIsValidString(szName));

	RETCODE nRetCode;
	UINT nField;
	if (!pFX->IsFieldType(&nField))
		return;

	LONG_PTR* plLength = pFX->m_prs->GetFieldLengthBuffer(
		nField - 1, pFX->m_nFieldType);

	BOOL bByRef = FALSE;
	switch (pFX->m_nOperation)
	{
	default:
LDefault:
		{
			void* pvData = NULL;
			if (value.GetSize() > 0)
			{
				if (bByRef)
					pvData = &value;
				else
					pvData = &value[0];
			}

			pFX->Default(szName, pvData, plLength, SQL_C_BINARY,
				(int)value.GetSize(), (UINT)value.GetSize());
		}
		return;

	case CFieldExchange::BindFieldToColumn:
		{
			// Assumes all bound fields BEFORE unbound fields
			CODBCFieldInfo* pODBCInfo =
				&pFX->m_prs->m_rgODBCFieldInfos[nField - 1];
			ULONG_PTR cbColumn = pODBCInfo->m_nPrecision;

#ifdef _DEBUG
			if (pODBCInfo->m_nSQLType != SQL_BINARY &&
				pODBCInfo->m_nSQLType != SQL_VARBINARY &&
				pODBCInfo->m_nSQLType != SQL_LONGVARBINARY)
			{
				// Warn of possible field schema mismatch
				TRACE(traceDatabase, 1, "Warning: CByteArray converted from SQL type %ld.\n",
					pODBCInfo->m_nSQLType);
			}
#endif // _DEBUG

			// Constrain to user specified max length
			if (cbColumn > (UINT_PTR)nMaxLength)
				cbColumn = nMaxLength;
			value.SetSize(cbColumn);
			AFX_SQL_SYNC(::SQLBindCol(pFX->m_prs->m_hstmt, (UWORD)nField,
				SQL_C_BINARY, &value[0], (LONG)cbColumn, plLength));
			if (!pFX->m_prs->Check(nRetCode))
				pFX->m_prs->ThrowDBException(nRetCode);

			// Add the member address to the field map
			pFX->m_prs->m_mapFieldIndex.SetAt(&value, (void*)(UINT_PTR)nField);
		}
		return;

	case CFieldExchange::Fixup:
		if (*plLength == SQL_NULL_DATA)
		{
			pFX->m_prs->SetNullFieldStatus(nField - 1);
			value.SetSize(1);
			value[0] = AFX_RFX_BYTE_PSEUDO_NULL;
		}
		else
		{
			ASSERT(*plLength <= (LONG)nMaxLength);
			((CDBByteArray&)value).SetLength((UINT)*plLength);
		}
		return;

	case CFieldExchange::SetFieldNull:
		if ((pFX->m_pvField == NULL &&
			pFX->m_nFieldType == CFieldExchange::outputColumn) ||
			pFX->m_pvField == &value)
		{
			if (pFX->m_bField)
			{
				// Mark fields null
				pFX->m_prs->SetNullFieldStatus(nField - 1);
				value.SetSize(1);
				value[0] = AFX_RFX_BYTE_PSEUDO_NULL;
				*plLength = SQL_NULL_DATA;
			}
			else
			{
				pFX->m_prs->ClearNullFieldStatus(nField - 1);
				*plLength = value.GetSize();
			}
#ifdef _DEBUG
			pFX->m_nFieldFound = nField;
#endif
		}
		return;

	case CFieldExchange::MarkForAddNew:
		// can force writing of psuedo-null value (as a non-null) by setting field dirty
		if (value.GetSize() != 1 || value[0] != AFX_RFX_BYTE_PSEUDO_NULL)
		{
			pFX->m_prs->SetDirtyFieldStatus(nField - 1);
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		}
		return;

	case CFieldExchange::MarkForUpdate:
		if (value.GetSize() != 1 || value[0] != AFX_RFX_BYTE_PSEUDO_NULL)
			pFX->m_prs->ClearNullFieldStatus(nField - 1);
		bByRef = TRUE;
		goto LDefault;

	case CFieldExchange::StoreField:
		AfxStoreField(*pFX->m_prs, nField, &value);
		return;

	case CFieldExchange::LoadField:
		AfxLoadField(*pFX->m_prs, nField, &value, plLength);
		return;

	case CFieldExchange::AllocCache:
		{
			CFieldInfo* pInfo = &pFX->m_prs->m_rgFieldInfos[nField - 1];
			pInfo->m_pvDataCache = new CByteArray;
			pInfo->m_nDataType = AFX_RFX_BINARY;
		}
		return;

#ifdef _DEBUG
	case CFieldExchange::DumpField:
		*pFX->m_pdcDump << "\n" << szName << ":";
		value.Dump(*pFX->m_pdcDump);
		return;
#endif // _DEBUG

	}
}

void AFXAPI RFX_Date(CFieldExchange* pFX, LPCTSTR szName, CTime& value)
{
	ENSURE_ARG(AfxIsValidAddress(pFX, sizeof(CFieldExchange)));
	ENSURE_ARG(AfxIsValidString(szName));

	RETCODE nRetCode=0;
	UINT nField=0;
	if (!pFX->IsFieldType(&nField))
		return;

	ENSURE(pFX->m_prs);
	LONG_PTR* plLength = pFX->m_prs->GetFieldLengthBuffer(
		nField - 1, pFX->m_nFieldType);
	ENSURE(plLength);

	switch (pFX->m_nOperation)
	{
	default:
LDefault:
		pFX->Default(szName, &value, plLength, SQL_C_TIMESTAMP,
			sizeof(value), TIMESTAMP_PRECISION);
		return;

	case CFieldExchange::BindParam:
		{
			TIMESTAMP_STRUCT* pts=NULL;
			pFX->m_prs->m_bRebindParams = TRUE;

			// Allocate proxy array if necessary
			if (pFX->m_prs->m_pvParamProxy == NULL)
			{
				pFX->m_prs->m_pvParamProxy = new void*[pFX->m_prs->m_nParams];
				memset(pFX->m_prs->m_pvParamProxy, 0,
					pFX->m_prs->m_nParams*sizeof(void*));
				pFX->m_prs->m_nProxyParams = pFX->m_prs->m_nParams;
			}

			// Allocate TIMESTAMP_STRUCT if necessary for SQLBindParameter
			if (pFX->m_prs->m_pvParamProxy[nField-1] == NULL)
				pFX->m_prs->m_pvParamProxy[nField-1] = new TIMESTAMP_STRUCT;

			pts = 