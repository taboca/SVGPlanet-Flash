// complex standard header
#pragma once
#ifndef _COMPLEX_
#define _COMPLEX_
#ifndef RC_INVOKED
#include <ymath.h>
#include <cmath>
#include <sstream>

#ifdef  _MSC_VER
#pragma pack(push,_CRT_PACKING)
#pragma warning(push,3)

 #pragma warning(disable: 4244)
#endif  /* _MSC_VER */

typedef struct _C_double_complex
	{	/* double complex */
	double _Val[2];
	} _C_double_complex;

typedef struct _C_float_complex
	{	/* float complex */
	float _Val[2];
	} _C_float_complex;

typedef struct _C_ldouble_complex
	{	/* long double complex */
	long double _Val[2];
	} _C_ldouble_complex;

	// COMPLEX _Val OFFSETS
 #define _RE	0
 #define _IM	1

_STD_BEGIN
typedef ::_C_double_complex _Dcomplex_value;
typedef ::_C_float_complex _Fcomplex_value;
typedef ::_C_ldouble_complex _Lcomplex_value;

#define __STD_COMPLEX	/* signal presence of complex classes */

		// TEMPLATE CLASS _Ctraits
template<class _Ty>
	class _Ctraits
	{	// complex traits for _Ty
public:
	static _Ty __CLRCALL_OR_CDECL _Cosh(_Ty _Left, _Ty _Right)
		{	// return cosh(_Left) * _Right
		return (::_Cosh((double)_Left, (double)_Right));
		}

	static short __CLRCALL_OR_CDECL _Exp(_Ty *_Pleft, _Ty _Right, short _Exponent)
		{	// compute exp(*_Pleft) * _Right * 2 ^ _Exponent
		double _Tmp = (double)*_Pleft;
		short _Ans = ::_Exp(&_Tmp, (double)_Right, _Exponent);
		*_Pleft = (_Ty)_Tmp;
		return (_Ans);
		}

	static _Ty __CLRCALL_OR_CDECL _Infv(_Ty)
		{	// return infinity
		return (::_Inf._Double);
		}

	static bool __CLRCALL_OR_CDECL _Isinf(_Ty _Left)
		{	// test for infinity
		double _Tmp = (double)_Left;
		return (::_Dtest(&_Tmp) == _INFCODE);
		}

	static bool __CLRCALL_OR_CDECL _Isnan(_Ty _Left)
		{	// test for NaN
		double _Tmp = (double)_Left;
		return (::_Dtest(&_Tmp) == _NANCODE);
		}

	static _Ty __CLRCALL_OR_CDECL _Nanv(_Ty)
		{	// return NaN
		return (::_Nan._Double);
		}

	static _Ty __CLRCALL_OR_CDECL _Sinh(_Ty _Left, _Ty _Right)
		{	// return sinh(_Left) * _Right
		return (::_Sinh((double)_Left, (double)_Right));
		}

	static _Ty __CLRCALL_OR_CDECL atan2(_Ty _Yval, _Ty _Xval)
		{	// return atan(_Yval / _Xval)
		return (::atan2((double)_Yval, (double)_Xval));
		}

	static _Ty __CLRCALL_OR_CDECL cos(_Ty _Left)
		{	// return cos(_Left)
		return (::cos((double)_Left));
		}

	static _Ty __CLRCALL_OR_CDECL exp(_Ty _Left)
		{	// return exp(_Left)
		return (::exp((double)_Left));
		}

	static _Ty __CLRCALL_OR_CDECL ldexp(_Ty _Left, int _Exponent)
		{	// return _Left * 2 ^ _Exponent
		return (::ldexp((double)_Left, _Exponent));
		}

	static _Ty __CLRCALL_OR_CDECL log(_Ty _Left)
		{	// return log(_Left)
		return (::log((double)_Left));
		}

	static _Ty __CLRCALL_OR_CDECL pow(_Ty _Left, _Ty _Right)
		{	// return _Left ^ _Right
		return (::pow((double)_Left, (double)_Right));
		}

	static _Ty __CLRCALL_OR_CDECL sin(_Ty _Left)
		{	// return sin(_Left)
		return (::sin((double)_Left));
		}

	static _Ty __CLRCALL_OR_CDECL sqrt(_Ty _Left)
		{	// return sqrt(_Left)
		return (::sqrt((double)_Left));
		}

	static _Ty __CLRCALL_OR_CDECL tan(_Ty _Left)
		{	// return tan(_Left)
		return (::tan((double)_Left));
		}
	};

		// CLASS _Ctraits<long double>
template<> class _CRTIMP2_PURE _Ctraits<long double>
	{	// complex traits for long double
public:
	typedef long double _Ty;

	static _Ty __CLRCALL_OR_CDECL _Cosh(_Ty _Left, _Ty _Right)
		{	// return cosh(_Left) * _Right
		return (::_LCosh(_Left, _Right));
		}

	static short __CLRCALL_OR_CDECL _Exp(_Ty *_Pleft, _Ty _Right, short _Exponent)
		{	// compute exp(*_Pleft) * _Right * 2 ^ _Exponent
		return (::_LExp(_Pleft, _Right, _Exponent));
		}

	static _Ty __CLRCALL_OR_CDECL _Infv(_Ty)
		{	// return infinity
		return (::_LInf._Long_double);
		}

	static bool __CLRCALL_OR_CDECL _Isinf(_Ty _Left)
		{	// test for infinity
		return (::_LDtest(&_Left) == _INFCODE);
		}

	static bool __CLRCALL_OR_CDECL _Isnan(_Ty _Left)
		{	// test for NaN
		return (::_LDtest(&_Left) == _NANCODE);
		}

	static _Ty __CLRCALL_OR_CDECL _Nanv(_Ty)
		{	// return NaN
		return (::_LNan._Long_double);
		}

	static _Ty __CLRCALL_OR_CDECL _Sinh(_Ty _Left, _Ty _Right)
		{	// return sinh(_Left) * _Right
		return (::_LSinh(_Left, _Right));
		}

	static _Ty __CLRCALL_OR_CDECL atan2(_Ty _Yval, _Ty _Xval)
		{	// return atan(_Yval / _Xval)
		return (::atan2l(_Yval, _Xval));
		}

	static _Ty __CLRCALL_OR_CDECL cos(_Ty _Left)
		{	// return cos(_Left)
		return (::cosl(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL exp(_Ty _Left)
		{	// return exp(_Left)
		return (::expl(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL ldexp(_Ty _Left, int _Exponent)
		{	// return _Left * 2 ^ _Exponent
		return (::ldexpl(_Left, _Exponent));
		}

	static _Ty __CLRCALL_OR_CDECL log(_Ty _Left)
		{	// return log(_Left)
		return (::logl(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL pow(_Ty _Left, _Ty _Right)
		{	// return _Left ^ _Right
		return (::powl(_Left, _Right));
		}

	static _Ty __CLRCALL_OR_CDECL sin(_Ty _Left)
		{	// return sin(_Left)
		return (::sinl(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL sqrt(_Ty _Left)
		{	// return sqrt(_Left)
		return (::sqrtl(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL tan(_Ty _Left)
		{	// return tan(_Left)
		return (::tanl(_Left));
		}
	};

		// CLASS _Ctraits<double>
template<> class _CRTIMP2_PURE _Ctraits<double>
	{	// complex traits for double
public:
	typedef double _Ty;

	static _Ty __CLRCALL_OR_CDECL _Cosh(_Ty _Left, _Ty _Right)
		{	// return cosh(_Left) * _Right
		return (::_Cosh(_Left, _Right));
		}

	static short __CLRCALL_OR_CDECL _Exp(_Ty *_Pleft, _Ty _Right, short _Exponent)
		{	// compute exp(*_Pleft) * _Right * 2 ^ _Exponent
		return (::_Exp(_Pleft, _Right, _Exponent));
		}

	static _Ty __CLRCALL_OR_CDECL _Infv(_Ty)
		{	// return infinity
		return (::_Inf._Double);
		}

	static bool __CLRCALL_OR_CDECL _Isinf(_Ty _Left)
		{	// test for infinity
		return (::_Dtest(&_Left) == _INFCODE);
		}

	static bool __CLRCALL_OR_CDECL _Isnan(_Ty _Left)
		{	// test for NaN
		return (::_Dtest(&_Left) == _NANCODE);
		}

	static _Ty __CLRCALL_OR_CDECL _Nanv(_Ty)
		{	// return NaN
		return (::_Nan._Double);
		}

	static _Ty __CLRCALL_OR_CDECL _Sinh(_Ty _Left, _Ty _Right)
		{	// return sinh(_Left) * _Right
		return (::_Sinh(_Left, _Right));
		}

	static _Ty __CLRCALL_OR_CDECL atan2(_Ty _Yval, _Ty _Xval)
		{	// return atan(_Yval / _Xval)
		return (::atan2(_Yval, _Xval));
		}

	static _Ty __CLRCALL_OR_CDECL cos(_Ty _Left)
		{	// return cos(_Left)
		return (::cos(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL exp(_Ty _Left)
		{	// return exp(_Left)
		return (::exp(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL ldexp(_Ty _Left, int _Exponent)
		{	// return _Left * 2 ^ _Exponent
		return (::ldexp(_Left, _Exponent));
		}

	static _Ty __CLRCALL_OR_CDECL log(_Ty _Left)
		{	// return log(_Left)
		return (::log(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL pow(_Ty _Left, _Ty _Right)
		{	// return _Left ^ _Right
		return (::pow(_Left, _Right));
		}

	static _Ty __CLRCALL_OR_CDECL sin(_Ty _Left)
		{	// return sin(_Left)
		return (::sin(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL sqrt(_Ty _Left)
		{	// return sqrt(_Left)
		return (::sqrt(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL tan(_Ty _Left)
		{	// return tan(_Left)
		return (::tan(_Left));
		}
	};

		// CLASS _Ctraits<float>
template<> class _CRTIMP2_PURE _Ctraits<float>
	{	// complex traits for float
public:
	typedef float _Ty;

	static _Ty __CLRCALL_OR_CDECL _Cosh(_Ty _Left, _Ty _Right)
		{	// return cosh(_Left) * _Right
		return (::_FCosh(_Left, _Right));
		}

	static short __CLRCALL_OR_CDECL _Exp(_Ty *_Pleft, _Ty _Right, short _Exponent)
		{	// compute exp(*_Pleft) * _Right * 2 ^ _Exponent
		return (::_FExp(_Pleft, _Right, _Exponent));
		}

	static _Ty __CLRCALL_OR_CDECL _Infv(_Ty)
		{	// return infinity
		return (::_FInf._Float);
		}

	static bool __CLRCALL_OR_CDECL _Isinf(_Ty _Left)
		{	// test for infinity
		return (::_FDtest(&_Left) == _INFCODE);
		}

	static bool __CLRCALL_OR_CDECL _Isnan(_Ty _Left)
		{	// test for NaN
		return (::_FDtest(&_Left) == _NANCODE);
		}

	static _Ty __CLRCALL_OR_CDECL _Nanv(_Ty)
		{	// return NaN
		return (::_FNan._Float);
		}

	static _Ty __CLRCALL_OR_CDECL _Sinh(_Ty _Left, _Ty _Right)
		{	// return sinh(_Left) * _Right
		return (::_FSinh(_Left, _Right));
		}

	static _Ty __CLRCALL_OR_CDECL atan2(_Ty _Yval, _Ty _Xval)
		{	// return atan(_Yval / _Xval)
		return (::atan2f(_Yval, _Xval));
		}

	static _Ty __CLRCALL_OR_CDECL cos(_Ty _Left)
		{	// return cos(_Left)
		return (::cosf(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL exp(_Ty _Left)
		{	// return exp(_Left)
		return (::expf(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL ldexp(_Ty _Left, int _Exponent)
		{	// return _Left * 2 ^ _Exponent
		return (::ldexpf(_Left, _Exponent));
		}

	static _Ty __CLRCALL_OR_CDECL log(_Ty _Left)
		{	// return log(_Left)
		return (::logf(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL pow(_Ty _Left, _Ty _Right)
		{	// return _Left ^ _Right
		return (::powf(_Left, _Right));
		}

	static _Ty __CLRCALL_OR_CDECL sin(_Ty _Left)
		{	// return sin(_Left)
		return (::sinf(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL sqrt(_Ty _Left)
		{	// return sqrt(_Left)
		return (::sqrtf(_Left));
		}

	static _Ty __CLRCALL_OR_CDECL tan(_Ty _Left)
		{	// return tan(_Left)
		return (::tanf(_Left));
		}
	};

template<class _Ty>
	class complex;
#ifndef _WIN32_WCE
template<> class _CRTIMP2_PURE complex<float>;
template<> class _CRTIMP2_PURE complex<double>;
template<> class _CRTIMP2_PURE complex<long double>;
#endif /* _WIN32_WCE */

		// TEMPLATE CLASS _Complex_value
template<class _Ty>
	struct _Complex_value
	{	/* templatized complex value */
	enum {_Re = 0, _Im = 1};
	_Ty _Val[2];
	};

		// TEMPLATE CLASS _Complex_base
template<class _Ty,
	class _Valbase>
	class _Complex_base
		: public _Valbase
	{	// base for all complex types
public:
	typedef _Ctraits<_Ty> _Myctraits;
	typedef _Complex_base<_Ty, _Valbase> _Myt;
	typedef _Ty value_type;

	_Complex_base(const _Ty& _Realval, const _Ty& _Imagval)
		{	// construct from components of same type
		this->_Val[_RE] = _Realval;
		this->_Val[_IM] = _Imagval;
		}

	_Ty real(const _Ty& _Right)
		{	// set real component
		return (this->_Val[_RE] = _Right);
		}

	_Ty imag(const _Ty& _Right)
		{	// set imaginary component
		return (this->_Val[_IM] = _Right);
		}

	_Ty real() const
		{	// return real component
		return (this->_Val[_RE]);
		}

	_Ty imag() const
		{	// return imaginary component
		return (this->_Val[_IM]);
		}

protected:
	template<class _Other> inline
		void _Add(const complex<_Other>& _Right)
		{	// add other complex
		this->_Val[_RE] = this->_Val[_RE] + (_Ty)_Right.real();
		this->_Val[_IM] = this->_Val[_IM] + (_Ty)_Right.imag();
		}

	template<class _Other> inline
		void _Sub(const complex<_Other>& _Right)
		{	// subtract other complex
		this->_Val[_RE] = this->_Val[_RE] - (_Ty)_Right.real();
		this->_Val[_IM] = this->_Val[_IM] - (_Ty)_Right.imag();
		}

	template<class _Other> inline
		void _Mul(const complex<_Other>& _Right)
		{	// multiply by other complex
		_Ty _Rightreal = (_Ty)_Right.real();
		_Ty _Rightimag = (_Ty)_Right.imag();

		_Ty _Tmp = this->_Val[_RE] * _Rightreal
			- this->_Val[_IM] * _Rightimag;
		this->_Val[_IM] = this->_Val[_RE] * _Rightimag
			+ this->_Val[_IM] * _Rightreal;
		this->_Val[_RE] = _Tmp;
		}

	template<class _Other> inline
		void _Div(const complex<_Other>& _Right)
		{	// divide by other complex
		typedef _Ctraits<_Ty> _Myctraits;
		_Ty _Rightreal = (_Ty)_Right.real();
		_Ty _Rightimag = (_Ty)_Right.imag();

		if (_Myctraits::_Isnan(_Rightreal) || _Myctraits::_Isnan(_Rightimag))
			{	// set NaN result
			this->_Val[_RE] = _Myctraits::_Nanv(_Rightreal);
			this->_Val[_IM] = this->_Val[_RE];
			}
		else if ((_Rightimag < 0 ? -_Rightimag : +_Rightimag)
			< (_Rightreal < 0 ? -_Rightreal : +_Rightreal))
			{	// |_Right.imag()| < |_Right.real()|
			_Ty _Wr = _Rightimag / _Rightreal;
			_Ty _Wd = _Rightreal + _Wr * _Rightimag;

			if (_Myctraits::_Isnan(_Wd) || _Wd == 0)
				{	// set NaN result
				this->_Val[_RE] = _Myctraits::_Nanv(_Rightreal);
				this->_Val[_IM] = this->_Val[_RE];
				}
			else
				{	// compute representable result
				_Ty _Tmp = (this->_Val[_RE]
					+ this->_Val[_IM] * _Wr) / _Wd;
				this->_Val[_IM] = (this->_Val[_IM]
					- this->_Val[_RE] * _Wr) / _Wd;
				this->_Val[_RE] = _Tmp;
				}
			}
		else if (_Rightimag == 0)
			{	// set NaN result
			this->_Val[_RE] = _Myctraits::_Nanv(_Rightreal);
			this->_Val[_IM] = this->_Val[_RE];
			}
		else
			{	// 0 < |_Right.real()| <= |_Right.imag()|
			_Ty _Wr = _Rightreal / _Rightimag;
			_Ty _Wd = _Rightimag + _Wr * _Rightreal;

			if (_Myctraits::_Isnan(_Wd) || _Wd == 0)
				{	// set NaN result
				this->_Val[_RE] = _Myctraits::_Nanv(_Rightreal);
				this->_Val[_IM] = this->_Val[_RE];
				}
			else
				{	// compute representable result
				_Ty _Tmp = (this->_Val[_RE] * _Wr + this->_Val[_IM]) / _Wd;
				this->_Val[_IM] = (this->_Val[_IM] * _Wr
					- this->_Val[_RE]) / _Wd;
				this->_Val[_RE] = _Tmp;
				}
			}
		}
	};

		// CLASS complex<float>
template<> class _CRTIMP2_PURE complex<float>
	: public _Complex_base<float, _Fcomplex_value>
	{	// complex with float components
public:
	typedef float _Ty;
	typedef complex<_Ty> _Myt;

	explicit complex(const complex<double>&);	// defined