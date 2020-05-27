package de.telekom.sea.mystuff.frontend.android.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import java.util.Date;

import de.telekom.sea.mystuff.frontend.android.BR;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class Item extends BaseObservable {

	public Item() {
	}

	@Builder
	public Item(long id, String name, int amount, String location, Date lastUsed) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.location = location;
		this.lastUsed = lastUsed;
	}

	public Item(long id, String name, int amount, String location, String description, Date lastUsed) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.location = location;
		this.description = description;
		this.lastUsed = lastUsed;
	}

	Long id;

	String name;

	int amount;

	String location;

	String description;

	Date lastUsed;

	@Bindable
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		notifyPropertyChanged(BR.id);
	}

	@Bindable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);
	}

	@Bindable
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		notifyPropertyChanged(BR.amount);
	}

	@Bindable
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		notifyPropertyChanged(BR.location);
	}

	@Bindable
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		notifyPropertyChanged(BR.description);
	}

	@Bindable
	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
		notifyPropertyChanged(BR.lastUsed);
	}
}
