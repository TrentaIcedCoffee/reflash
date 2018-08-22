package reflash.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {
	public static final String KEYSPACE = "reflash_keyspace";

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(CassandraConfig.KEYSPACE);
		return Arrays.asList(specification);
	}

	@Override
	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
		return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(CassandraConfig.KEYSPACE));
	}

	@Override
	protected String getKeyspaceName() {
		return CassandraConfig.KEYSPACE;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] {"reflash.domain"};
	}
}
