package br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model;

import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.FolhaPagamento;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Modalidade;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-02T09:15:24", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Professor.class)
public class Professor_ extends Pessoa_ {

    public static volatile ListAttribute<Professor, FolhaPagamento> holerites;
    public static volatile ListAttribute<Professor, Modalidade> modalidades;
    public static volatile SingularAttribute<Professor, Calendar> dataAdmissao;

}