package info.riado.domain;

/**
 * @author ivan
 */

public interface EntityFactory<T extends BaseEntity> {

	T create();

	public EntityFactory<Chamber> CHAMBERS_FACTORY = Chamber::new;
	public EntityFactory<Lawyer> LAWYERS_FACTORY = Lawyer::new;
	public EntityFactory<Formation> FORMATIONS_FACTORY = Formation::new;

}
