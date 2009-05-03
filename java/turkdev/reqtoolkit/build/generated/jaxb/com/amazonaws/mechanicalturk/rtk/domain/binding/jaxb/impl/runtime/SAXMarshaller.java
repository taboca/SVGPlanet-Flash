r
		_DEBUG_POINTER(_Pfn);
		return ((*_Pfn)(*this));
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(_Myios& (__clrcall *_Pfn)(_Myios&))
		{	// call basic_ios manipulator
		_DEBUG_POINTER(_Pfn);
		(*_Pfn)(*(_Myios *)this);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(ios_base& (__clrcall *_Pfn)(ios_base&))
		{	// call ios_base manipulator
		_DEBUG_POINTER(_Pfn);
		(*_Pfn)(*(ios_base *)this);
		return (*this);
		}
#endif

	_Myt& __CLR_OR_THIS_CALL operator>>(_Myt& (__cdecl *_Pfn)(_Myt&))
		{	// call basic_istream manipulator
		_DEBUG_POINTER(_Pfn);
		return ((*_Pfn)(*this));
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(_Myios& (__cdecl *_Pfn)(_Myios&))
		{	// call basic_ios manipulator
		_DEBUG_POINTER(_Pfn);
		(*_Pfn)(*(_Myios *)this);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(ios_base& (__cdecl *_Pfn)(ios_base&))
		{	// call ios_base manipulator
		_DEBUG_POINTER(_Pfn);
		(*_Pfn)(*(ios_base *)this);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(_Bool& _Val)
		{	// extract a boolean
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(short& _Val)
		{	// extract a short
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
			long _Tmp = 0;
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Tmp);
			_CATCH_IO_END

			if (_State & ios_base::failbit
				|| _Tmp < SHRT_MIN || SHRT_MAX < _Tmp)
				_State |= ios_base::failbit;
			else
				_Val = (short)_Tmp;
			}

		_Myios::setstate(_State);
		return (*this);
		}

        /*  Note that if your stream is wchar_t, and you are not using native wchar_t
            Then this operation will be unavailable as there is an explicit 
            specialisation further down this file that is designed to treat an 
            unsigned short as a character.

            If you wish to read or write unsigned shorts to wchar_t streams, you should 
            consider making wchar_t a native type by turning on /Zc:wchar_t
        */
	_Myt& __CLR_OR_THIS_CALL operator>>(unsigned short& _Val)
		{	// extract an unsigned short
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(int& _Val)
		{	// extract an int
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
			long _Tmp = 0;
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Tmp);
			_CATCH_IO_END

			if (_State & ios_base::failbit
				|| _Tmp < INT_MIN || INT_MAX < _Tmp)
				_State |= ios_base::failbit;
			else
				_Val = _Tmp;
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(unsigned int& _Val)
		{	// extract an unsigned int
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);
		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(long& _Val)
		{	// extract a long
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif
			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(unsigned long __w64& _Val)
		{	// extract an unsigned long
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, (unsigned long)_Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

 #ifdef _LONGLONG
	_Myt& __CLR_OR_THIS_CALL operator>>(_LONGLONG& _Val)
		{	// extract a long long
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(_ULONGLONG& _Val)
		{	// extract an  unsigned long long
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);
		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}
 #endif /* _LONGLONG */

	_Myt& __CLR_OR_THIS_CALL operator>>(float& _Val)
		{	// extract a float
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(double& _Val)
		{	// extract a double
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);
		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(long double& _Val)
		{	// extract a long double
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif
			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(void *& _Val)
		{	// extract a void pointer
		ios_base::iostate _State = ios_base::goodbit;
		const sentry _Ok(*this);

		if (_Ok)
			{	// state okay, use facet to extract
#if defined(_WIN32_WCE)
			const _Nget _Nget_fac;
#else
			const _Nget& _Nget_fac = _USE(ios_base::getloc(), _Nget);
#endif

			_TRY_IO_BEGIN
			_Nget_fac.get(_Iter(_Myios::rdbuf()), _Iter(0),
				*this, _State, _Val);
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL operator>>(_Mysb *_Strbuf)
		{	// extract until end-of-file into a stream buffer
		ios_base::iostate _State = ios_base::goodbit;
		bool _Copied = false;
		const sentry _Ok(*this);

		if (_Ok && _Strbuf != 0)
			{	// state okay, extract characters
			_TRY_IO_BEGIN
			int_type _Meta = _Myios::rdbuf()->sgetc();

			for (; ; _Meta = _Myios::rdbuf()->snextc())
				if (_Traits::eq_int_type(_Traits::eof(), _Meta))
					{	// end of file, quit
					_State |= ios_base::eofbit;
					break;
					}
				else
					{	// got a character, insert it into buffer
					_TRY_BEGIN
						if (_Traits::eq_int_type(_Traits::eof(),
							_Strbuf->sputc(_Traits::to_char_type(_Meta))))
							break;
					_CATCH_ALL
						break;
					_CATCH_END
					_Copied = true;
					}
			_CATCH_IO_END
			}

		_Myios::setstate(!_Copied ? _State | ios_base::failbit : _State);
		return (*this);
		}

	int_type __CLR_OR_THIS_CALL get()
		{	// extract a metacharacter
		int_type _Meta = 0;
		ios_base::iostate _State = ios_base::goodbit;
		_Chcount = 0;
		const sentry _Ok(*this, true);

		if (!_Ok)
			_Meta = _Traits::eof();	// state not okay, return EOF
		else
			{	// state okay, extract a character
			_TRY_IO_BEGIN
			_Meta = _Myios::rdbuf()->sbumpc();

			if (_Traits::eq_int_type(_Traits::eof(), _Meta))
				_State |= ios_base::eofbit | ios_base::failbit;	// end of file
			else
				++_Chcount;	// got a character, count it
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (_Meta);
		}

	_Myt& __CLR_OR_THIS_CALL get(_Elem *_Str, streamsize _Count)
		{	// get up to _Count characters into NTCS
		return (get(_Str, _Count, _Myios::widen('\n')));
		}

	_Myt& __CLR_OR_THIS_CALL get(_Elem *_Str,
		streamsize _Count, _Elem _Delim)
		{	// get up to _Count characters into NTCS, stop before _Delim
		_DEBUG_POINTER(_Str);
		ios_base::iostate _State = ios_base::goodbit;
		_Chcount = 0;
		const sentry _Ok(*this, true);

		if (_Ok && 0 < _Count)
			{	// state okay, extract characters
			_TRY_IO_BEGIN
			int_type _Meta = _Myios::rdbuf()->sgetc();

			for (; 0 < --_Count; _Meta = _Myios::rdbuf()->snextc())
				if (_Traits::eq_int_type(_Traits::eof(), _Meta))
					{	// end of file, quit
					_State |= ios_base::eofbit;
					break;
					}
				else if (_Traits::to_char_type(_Meta) == _Delim)
					break;	// got a delimiter, quit
				else
					{	// got a character, add it to string
					*_Str++ = _Traits::to_char_type(_Meta);
					++_Chcount;
					}
			_CATCH_IO_END
			}

		_Myios::setstate(_Chcount == 0
			? _State | ios_base::failbit : _State);
		*_Str = _Elem();	// add terminating null character
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL get(_Elem& _Ch)
		{	// get a character
		int_type _Meta = get();
		if (!_Traits::eq_int_type(_Traits::eof(), _Meta))
			_Ch = _Traits::to_char_type(_Meta);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL get(_Mysb& _Strbuf)
		{	// extract up to newline and insert into stream buffer
		return (get(_Strbuf, _Myios::widen('\n')));
		}

	_Myt& __CLR_OR_THIS_CALL get(_Mysb& _Strbuf, _Elem _Delim)
		{	// extract up to delimiter and insert into stream buffer
		ios_base::iostate _State = ios_base::goodbit;
		_Chcount = 0;
		const sentry _Ok(*this, true);

		if (_Ok)
			{	// state okay, use facet to extract
			_TRY_IO_BEGIN
			int_type _Meta = _Myios::rdbuf()->sgetc();

			for (; ; _Meta = _Myios::rdbuf()->snextc())
				if (_Traits::eq_int_type(_Traits::eof(), _Meta))
					{	// end of file, quit
					_State |= ios_base::eofbit;
					break;
					}
				else
					{	// got a character, insert it into stream buffer
					_TRY_BEGIN
						_Elem _Ch = _Traits::to_char_type(_Meta);
						if (_Ch == _Delim
							|| _Traits::eq_int_type(_Traits::eof(),
								_Strbuf.sputc(_Ch)))
							break;
					_CATCH_ALL
						break;
					_CATCH_END
					++_Chcount;
					}
			_CATCH_IO_END
			}

		if (_Chcount == 0)
			_State |= ios_base::failbit;
		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL getline(_Elem *_Str, streamsize _Count)
		{	// get up to _Count characters into NTCS, discard newline
		return (getline(_Str, _Count, _Myios::widen('\n')));
		}

	_Myt& __CLR_OR_THIS_CALL getline(_Elem *_Str,
		streamsize _Count, _Elem _Delim)
		{	// get up to _Count characters into NTCS, discard _Delim
		_DEBUG_POINTER(_Str);
		ios_base::iostate _State = ios_base::goodbit;
		_Chcount = 0;
		const sentry _Ok(*this, true);

		if (_Ok && 0 < _Count)
			{	// state okay, use facet to extract
			int_type _Metadelim = _Traits::to_int_type(_Delim);

			_TRY_IO_BEGIN
			int_type _Meta = _Myios::rdbuf()->sgetc();

			for (; ; _Meta = _Myios::rdbuf()->snextc())
				if (_Traits::eq_int_type(_Traits::eof(), _Meta))
					{	// end of file, quit
					_State |= ios_base::eofbit;
					break;
					}
				else if (_Meta == _Metadelim)
					{	// got a delimiter, discard it and quit
					++_Chcount;
					_Myios::rdbuf()->sbumpc();
					break;
					}
				else if (--_Count <= 0)
					{	// buffer full, quit
					_State |= ios_base::failbit;
					break;
					}
				else
					{	// got a character, add it to string
					++_Chcount;
					*_Str++ = _Traits::to_char_type(_Meta);
					}
			_CATCH_IO_END
			}

		*_Str = _Elem();	// add terminating null character
		_Myios::setstate(_Chcount == 0 ? _State | ios_base::failbit : _State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL ignore(streamsize _Count = 1,
		int_type _Metadelim = _Traits::eof())
		{	// ignore up to _Count characters, discarding delimiter
		ios_base::iostate _State = ios_base::goodbit;
		_Chcount = 0;
		const sentry _Ok(*this, true);

		if (_Ok && 0 < _Count)
			{	// state okay, use facet to extract
			_TRY_IO_BEGIN
			for (; ; )
				{	// get a metacharacter if more room in buffer
				int_type _Meta;
				if (_Count != INT_MAX && --_Count < 0)
					break;	// buffer full, quit
				else if (_Traits::eq_int_type(_Traits::eof(),
					_Meta = _Myios::rdbuf()->sbumpc()))
					{	// end of file, quit
					_State |= ios_base::eofbit;
					break;
					}
				else
					{	// got a character, count it
					++_Chcount;
					if (_Meta == _Metadelim)
						break;	// got a delimiter, quit
					}
				}
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL _Read_s(_Elem *_Str, size_t _Str_size, streamsize _Count)
		{	// read up to _Count characters into buffer
		_DEBUG_POINTER(_Str);
		ios_base::iostate _State = ios_base::goodbit;
		_Chcount = 0;
		const sentry _Ok(*this, true);

		if (_Ok)
			{	// state okay, use facet to extract
			_TRY_IO_BEGIN
			const streamsize _Num = _Myios::rdbuf()->_Sgetn_s(_Str, _Str_size, _Count);
			_Chcount += _Num;
			if (_Num != _Count)
				_State |= ios_base::eofbit | ios_base::failbit;	// short read
			_CATCH_IO_END
			}

		_Myios::setstate(_State);
		return (*this);
		}

	_Myt& __CLR_OR_THIS_CALL read(_Elem *_Str, streamsize _Count)
		{
		return _Read_s(_Str, (size_t)-1, _Count);
		}

	streamsize __CLR_OR_THIS_CALL _Readsome_s(_Elem *_Str, size_t _Str_size, streamsize _Count)
		{	// read up to _Count charac