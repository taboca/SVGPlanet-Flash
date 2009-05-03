ame="OSCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="OS"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Debugger Container -->
<xsd:element name="DEBUGGERCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="DEBUGGER"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Debugger -->
<xsd:element name="DEBUGGER">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element minOccurs="0" ref="DETYPECONTAINER"/>
			<xsd:element minOccurs="0" ref="SHCPUMAPCONTAINER"/>
			<xsd:element minOccurs="0" ref="OSCONTAINER"/>
			<xsd:element minOccurs="0" ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- ********************************************************************** -->
<!-- Devices                                                                -->
<!-- ********************************************************************** -->

<!-- Device Container -->
<xsd:element name="DEVICECONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="DEVICE"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Device -->
<xsd:element name="DEVICE">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- ********************************************************************** -->
<!-- OS Images                                                              -->
<!-- ********************************************************************** -->

<!-- OS Image Container -->
<xsd:element name="OSIMAGECONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="OSIMAGE"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- OS Image -->
<xsd:element name="OSIMAGE">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- ********************************************************************** -->
<!-- Packages                                                               -->
<!-- ********************************************************************** -->

<!-- Package Container -->
<xsd:element name="PACKAGECONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="PACKAGE"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Package -->
<xsd:element name="PACKAGE">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PACKAGETYPECONTAINER"/>
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- The package type container -->
<xsd:element name="PACKAGETYPECONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="PACKAGETYPE"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- The package type -->
<xsd:element name="PACKAGETYPE">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="FILECONTAINER"/>
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- The file container -->
<xsd:element name="FILECONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="FILE"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- The file -->
<xsd:element name="FILE">
	<xsd:complexType>
		<!-- This can have an optional file container -->
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element minOccurs="0" ref="FILECONTAINER"/>
			<xsd:element minOccurs="0" ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- ********************************************************************** -->
<!-- Platforms                                                              -->
<!-- ********************************************************************** -->

<!-- Platform Container -->
<xsd:element name="PLATFORMCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="PLATFORM"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Platform -->
<xsd:element name="PLATFORM">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="DEVICECONTAINER"/>
			<xsd:element ref="PROJECTCONTAINER"/>
			<xsd:element ref="TYPE_TO_ARCHITECTURE_MAP"/>
      <xsd:element ref="FORMFACTORCONTAINER"/>
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Type to architecture map -->
<xsd:element name="TYPE_TO_ARCHITECTURE_MAP">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- form factor -->
<xsd:element name="FORMFACTOR">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- form factor container -->
<xsd:element name="FORMFACTORCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="FORMFACTOR"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Project Container -->
<xsd:element name="PROJECTCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="PROJECT"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Project -->
<xsd:element name="PROJECT">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- ********************************************************************** -->
<!-- Properties                                                             -->
<!-- ********************************************************************** -->

<!-- The property container -->
<xsd:element name="PROPERTYCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="PROPERTY"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- The property -->
<xsd:element name="PROPERTY">
	<xsd:complexType mixed="true">

		<!-- This is hard to get right.
		<xsd:simpleContent>
			<xsd:extension base="xsd:string">
				<xsd:attribute name="ID" type="xsd:string"
					use="required"/>
			</xsd:extension>
		</xsd:simpleContent>
		-->

		<!-- So instead, i'll just used mixed -->
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="_UseVSRelativePath" type="xsd:string"/>
		<xsd:attribute name="_UseCcRelativePath" type="xsd:string"/>
		<xsd:attribute name="_UseNetCFRelativePath" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- ********************************************************************** -->
<!-- Service Categories                                                     -->
<!-- ********************************************************************** -->

<!-- Service Category Container -->
<xsd:element name="SERVICECATEGORYCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="SERVICECATEGORY"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
		<xsd:attribute name="Version" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Service Category -->
<xsd:element name="SERVICECATEGORY">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="SERVICEINFOCONTAINER"/>
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Service Info Container -->
<xsd:element name="SERVICEINFOCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="SERVICEINFO"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Service Info -->
<xsd:element name="SERVICEINFO">
	<xsd:complexType>
		<xsd:all minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:all>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- ********************************************************************** -->
<!-- Type Map                                                               -->
<!-- ********************************************************************** -->

<!-- QIS -->
<xsd:element name="QIS">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="1">
			<xsd:element ref="PROPERTYCONTAINER"/>
		</xsd:sequence>
		<xsd:attribute name="ID" type="xsd:string" use="required"/>
		<xsd:attribute name="Name" type="xsd:string"/>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- QIS Container -->
<xsd:element name="QISCONTAINER">
	<xsd:complexType>
		<xsd:sequence minOccurs="0" maxOccurs="unbounded">
			<xsd:element ref="QIS"/>
		</xsd:sequence>
		<xsd:attribute name="Protected" type="xsd:string"/>
	</xsd:complexType>
</xsd:element>

<!-- Level -->
<xsd:element name="LEVEL">
	<xsd:comple