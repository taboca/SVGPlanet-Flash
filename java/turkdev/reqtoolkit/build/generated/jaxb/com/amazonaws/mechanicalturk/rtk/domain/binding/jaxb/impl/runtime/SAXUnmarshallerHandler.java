Tip( int index, const QString &amp;toolTip );
    QString itemToolTip( int index ) const;

    QWidget *currentItem() const;
    void setCurrentItem( QWidget *item );

    int currentIndex() const;
    QWidget *item( int index ) const;
    int indexOf( QWidget *item ) const;
    int count() const;

public slots:
    void setCurrentIndex( int index );

signals:
    void currentChanged( int index );

private slots:
    void buttonClicked();
    void itemDestroyed(QObject*);

protected:
    virtual void itemInserted( int index );
    virtual void itemRemoved( int index );
    void showEvent( QShowEvent *e );
    void frameChanged();
    void styleChange(QStyle&amp;);

private:
    void relayout();

private:
    QToolBoxPrivate *d;

};


inline int QToolBox::addItem( QWidget *item, const QString &amp;label )
{ return insertItem( -1, item, QIconSet(), label ); }
inline int QToolBox::addItem( QWidget *item, const QIconSet &amp;iconSet,
			      const QString &amp;label )
{ return insertItem( -1, item, iconSet, label ); }
inline int QToolBox::insertItem( int index, QWidget *item, const QString &amp;label )
{ return insertItem( index, item, QIconSet(), label ); }

#endif // QT_NO_TOOLBOX
#endif
</pre>
<!-- eof -->
<p><address><hr><div align=center>
<table width=100% cellspacing=0 border=0><tr>
<td>Copyright &copy; 2004
<a href="troll.html">Trolltech</a><td align=center><a href="trademarks.html">Trademarks</a>
<td align=right><div align=right>