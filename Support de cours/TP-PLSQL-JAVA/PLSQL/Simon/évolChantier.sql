ALTER TABLE vehicule ADD capacite int CONSTRAINT vehicule_cap_min CHECK (capacite >= 0);
ALTER TABLE chantier ADD v_interdit int;