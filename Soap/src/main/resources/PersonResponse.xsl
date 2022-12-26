<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

    <xsl:template match="/">
        <person>
            <xsl:for-each select="person/*[not(self::document)]">
                <xsl:attribute name="{name()}">
                    <xsl:value-of select="text()"/>
                </xsl:attribute>
            </xsl:for-each>
            <xsl:attribute name="birthDate">
                <xsl:value-of select="format-date(xs:date(person/birthDate),'[D01].[M01].[Y0001]')"/>
            </xsl:attribute>
            <document>
                <xsl:for-each select="person/document/*">
                    <xsl:attribute name="{name()}">
                        <xsl:value-of select="text()"/>
                    </xsl:attribute>
                </xsl:for-each>
                <xsl:attribute name="issueDate">
                    <xsl:value-of select="format-date(xs:date(person/document/issueDate),'[D01].[M01].[Y0001]')"/>
                </xsl:attribute>
            </document>
        </person>
    </xsl:template>

</xsl:stylesheet>