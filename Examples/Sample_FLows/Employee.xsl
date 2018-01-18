<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:foo="http://www.foo.org/" xmlns:bar="http://www.bar.org">
<xsl:template match="/">
	<html>
		<body>
			<h2>M Collection Data </h2>
				<table border="1">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Designation</th>
						<th>Salary</th>
					</tr>
					<xsl:for-each select="Employees/Employee">
						<tr>
							<td><xsl:value-of select="Id"/></td>
							<td><xsl:value-of select="Name"/></td>
							<td><xsl:value-of select="Designation"/></td>
							<td><xsl:value-of select="Salary"/></td>
						</tr>
					</xsl:for-each>
				</table>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>